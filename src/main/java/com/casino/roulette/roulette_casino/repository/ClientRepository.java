package com.casino.roulette.roulette_casino.repository;

import com.casino.roulette.roulette_casino.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
}
