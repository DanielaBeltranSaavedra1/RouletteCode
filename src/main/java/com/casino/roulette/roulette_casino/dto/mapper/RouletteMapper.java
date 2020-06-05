package com.casino.roulette.roulette_casino.dto.mapper;

import com.casino.roulette.roulette_casino.dto.model.RouletteDto;
import com.casino.roulette.roulette_casino.model.Roulette;

public class RouletteMapper {
    public static RouletteDto toRouletteDto(Roulette roulette) {
        String rouletteState = ((roulette.getState()) ? "Open" : "Closed");

        return new RouletteDto()
                .setId(roulette.getId())
                .setState(rouletteState);
    }
}
