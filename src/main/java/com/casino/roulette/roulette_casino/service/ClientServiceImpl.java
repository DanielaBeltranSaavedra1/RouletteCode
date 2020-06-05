package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientServiceImpl implements ClientService{
    @Autowired
    private  ClientRepository clientRepository;

    @Override
    public Optional<Client> getClientById(String clientId) {
        return clientRepository.findById(clientId);
    }
}
