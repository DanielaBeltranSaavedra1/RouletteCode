package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.model.Client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientById(String clientId);
}
