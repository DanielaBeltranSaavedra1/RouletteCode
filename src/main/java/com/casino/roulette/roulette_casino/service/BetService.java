package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.model.BetResultsDto;
import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.model.Colour;
import com.casino.roulette.roulette_casino.model.Roulette;

public interface BetService {
    Boolean createBet(Client client, Roulette roulette, float amount, int number, Colour color);

    BetResultsDto closeBet(String rouletteId);
}
