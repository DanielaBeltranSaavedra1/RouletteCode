package com.casino.roulette.roulette_casino.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@RedisHash("Bet")
public class Bet implements Serializable {
    private String id;
    private int number;
    private String color;
    private float amount;
    private String clientId;
    private String rouletteId;
}
