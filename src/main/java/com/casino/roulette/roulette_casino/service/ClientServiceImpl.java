package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.mapper.ClientMapper;
import com.casino.roulette.roulette_casino.dto.model.ClientDto;
import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<Client> getClientById(String clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public Boolean subtractBet(Client client, float amount) {
        client.setBalance(
                client.getBalance() - amount
        );
        if (client.getBalance() >= 0) {
            clientRepository.save(client);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public String createClient(String name, float balance) {
        String uuid = UUID.randomUUID().toString();
        Client newClient = new Client()
                .setId(uuid)
                .setName(name)
                .setBalance(balance);
        clientRepository.save(newClient);

        return uuid;
    }

    @Override
    public List<ClientDto> getClientList() {
        List<ClientDto> clients = new ArrayList<>();
        clientRepository.findAll().forEach(
                client -> clients.add(ClientMapper.toClientDto(client))
        );

        return clients;
    }
}
