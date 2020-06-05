package com.casino.roulette.roulette_casino.service;

import com.casino.roulette.roulette_casino.dto.mapper.RouletteMapper;
import com.casino.roulette.roulette_casino.dto.model.RouletteDto;
import com.casino.roulette.roulette_casino.model.Roulette;
import com.casino.roulette.roulette_casino.repository.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
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
        boolean error = true;
        Optional<Roulette> roulette = rouletteRepository.findById(rouletteId);
        if (roulette.isPresent()){
            Roulette r = roulette.get();
            if (!r.getState()) {
                r.setState(Boolean.TRUE);
                rouletteRepository.save(r);
                error = false;
            }
        }

        return !error;
    }

    @Override
    public Boolean closeRoulette(String rouletteId) {
        boolean error = true;
        Optional<Roulette> roulette = rouletteRepository.findById(rouletteId);
        if (roulette.isPresent()){
            Roulette r = roulette.get();
            if (r.getState()) {
                r.setState(Boolean.FALSE);
                rouletteRepository.save(r);
                error = false;
            }
        }

        return !error;
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
