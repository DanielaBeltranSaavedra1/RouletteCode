package com.casino.roulette.roulette_casino.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@RedisHash("Roulette")
public class Roulette implements Serializable {
    private  @Id String id;
    private Boolean state;
}
