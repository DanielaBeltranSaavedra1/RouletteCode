package com.casino.roulette.roulette_casino.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@RedisHash("Bet")
public class Bet implements Serializable {
    private  @Id String id;
    private int number;
    private Colour colour;
    private float amount;
    private String clientId;
    private @Indexed String rouletteId;
    private Boolean win;
}
