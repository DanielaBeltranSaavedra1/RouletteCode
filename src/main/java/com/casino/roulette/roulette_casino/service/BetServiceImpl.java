package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.mapper.BetMapper;
import com.casino.roulette.roulette_casino.dto.model.BetDto;
import com.casino.roulette.roulette_casino.dto.model.BetResultsDto;
import com.casino.roulette.roulette_casino.model.Bet;
import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.model.Colour;
import com.casino.roulette.roulette_casino.model.Roulette;
import com.casino.roulette.roulette_casino.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetRepository betRepository;
    @Autowired
    private Random random;

    @Override
    public Boolean createBet(Client client, Roulette roulette, float amount, int number, Colour color) {
        if (client.getBalance() >= amount && roulette.getState()) {
            String uuid = UUID.randomUUID().toString();
            Bet bet = new Bet()
                    .setId(uuid)
                    .setAmount(amount)
                    .setClientId(client.getId())
                    .setRouletteId(roulette.getId())
                    .setColour(color)
                    .setNumber(number)
                    .setWin(Boolean.FALSE);
            betRepository.save(bet);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public BetResultsDto closeBet(String rouletteId) {
        int winnerNumber = random.nextInt(37);
        Colour[] validColours = {Colour.BLACK, Colour.RED};
        Colour winnerColour = validColours[random.nextInt(validColours.length)];
        List<BetDto> betList = new ArrayList<>();
        betRepository.findByRouletteId(rouletteId).forEach(
                bet -> {
                    Boolean colourWinnerState = bet.getColour() == winnerColour;
                    Boolean numberWinnerState = bet.getNumber() == winnerNumber;
                    bet.setWin(colourWinnerState || numberWinnerState);
                    betList.add(
                            BetMapper.toBetDto(bet)
                    );
                    betRepository.save(bet);
                }
        );

        return new BetResultsDto()
                .setBetList(betList)
                .setRouletteId(rouletteId)
                .setWinnerColour(winnerColour.value)
                .setWinnerNumber(winnerNumber);
    }
}
