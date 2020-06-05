package com.casino.roulette.roulette_casino.dto.mapper;

import com.casino.roulette.roulette_casino.dto.model.ClientDto;
import com.casino.roulette.roulette_casino.model.Client;

public class ClientMapper {
    public static ClientDto toClientDto(Client client) {
        return new ClientDto()
                .setBalance(client.getBalance())
                .setClientId(client.getId())
                .setName(client.getName());
    }
}
