package com.casino.roulette.roulette_casino.repository;

import com.casino.roulette.roulette_casino.model.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BetRepository extends CrudRepository<Bet, String> {
    Iterable<Bet> findByRouletteId(String rouletteId);
}
