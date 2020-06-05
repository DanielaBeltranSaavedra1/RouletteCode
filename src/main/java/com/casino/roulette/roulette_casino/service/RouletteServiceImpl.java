package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.mapper.RouletteMapper;
import com.casino.roulette.roulette_casino.dto.model.RouletteDto;
import com.casino.roulette.roulette_casino.model.Roulette;
import com.casino.roulette.roulette_casino.repository.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RouletteServiceImpl implements RouletteService {

    @Autowired
    private RouletteRepository rouletteRepository;

    @Override
    public String createRoulette() {
        String uuid = UUID.randomUUID().toString();
        Roulette newRoulette = new Roulette()
                .setId(uuid)
                .setState(Boolean.FALSE);
        rouletteRepository.save(newRoulette);

        return uuid;
    }

    @Override
    public Boolean openRoulette(String rouletteId) {
        Optional<Roulette> roulette = rouletteRepository.findById(rouletteId);
        roulette.ifPresent(
                r -> {
                    if (!r.getState()) {
                        r.setState(Boolean.TRUE);
                        rouletteRepository.save(r);
                    }
                }
        );

        return Boolean.FALSE;
    }

    @Override
    public Optional<Roulette> getRouletteById(String rouletteId) {
        return rouletteRepository.findById(rouletteId);
    }

    @Override
    public List<RouletteDto> getAllRouletteList() {
        List<RouletteDto> rouletteList = new ArrayList<>();
        rouletteRepository.findAll().forEach(r ->
                rouletteList.add(
                        RouletteMapper.toRouletteDto(r)
                )
        );

        return rouletteList;
    }
}
