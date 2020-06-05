package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.model.ClientDto;
import com.casino.roulette.roulette_casino.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientById(String clientId);
    Boolean subtractBet (Client client, float amount);
    String createClient ( String name, float balance);
    List<ClientDto> getClientList();
}
