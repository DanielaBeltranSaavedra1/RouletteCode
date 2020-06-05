package com.casino.roulette.roulette_casino.repository;

import com.casino.roulette.roulette_casino.model.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends CrudRepository<Bet, String> {
}
