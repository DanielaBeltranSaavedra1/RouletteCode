package com.casino.roulette.roulette_casino.dto.mapper;

import com.casino.roulette.roulette_casino.dto.model.BetDto;
import com.casino.roulette.roulette_casino.model.Bet;

public class BetMapper {
    public static BetDto toBetDto(Bet bet) {
        return new BetDto()
                .setClientId(bet.getClientId())
                .setColour(bet.getColour().value)
                .setNumber(bet.getNumber())
                .setTotalAmount(bet.getAmount());
    }
}
