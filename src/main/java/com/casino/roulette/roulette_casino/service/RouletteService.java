package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.model.RouletteDto;
import com.casino.roulette.roulette_casino.model.Roulette;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface RouletteService {
    String createRoulette();
    Boolean openRoulette(String rouletteId);
    Boolean closeRoulette(String rouletteId);
    Optional<Roulette> getRouletteById(String rouletteId);
    List<RouletteDto> getAllRouletteList();
}
