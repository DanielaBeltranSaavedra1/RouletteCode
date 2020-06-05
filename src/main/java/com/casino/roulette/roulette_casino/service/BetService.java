package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.model.Bet;
import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.model.Roulette;

import java.util.ArrayList;

public interface BetService {
    Boolean createBet(Client client, Roulette roulette, float amount, int number, String color);
}
