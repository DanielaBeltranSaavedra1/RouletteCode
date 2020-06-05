package com.casino.roulette.roulette_casino.repository;

import com.casino.roulette.roulette_casino.model.Roulette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String> {
}
