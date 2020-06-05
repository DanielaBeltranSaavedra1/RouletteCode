package com.casino.roulette.roulette_casino.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CasinoConfig {
    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public Random random() {
        return new Random();
    }
}
