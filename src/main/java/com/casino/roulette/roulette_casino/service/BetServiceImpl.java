package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.model.Bet;
import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.model.Roulette;
import com.casino.roulette.roulette_casino.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class BetServiceImpl implements BetService{

    @Autowired
    private BetRepository betRepository;

    @Override
    public Boolean createBet(Client client, Roulette roulette, float amount, int number, String color) {
        if ( client.getBalance() >= amount && roulette.getState()) {
            String uuid = UUID.randomUUID().toString();
            Bet bet = new Bet()
                    .setId(uuid)
                    .setAmount(amount)
                    .setClientId(client.getId())
                    .setRouletteId(roulette.getId())
                    .setColor(color)
                    .setNumber(number);
            betRepository.save(bet);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
