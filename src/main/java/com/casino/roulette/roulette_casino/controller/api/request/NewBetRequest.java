package com.casino.roulette.roulette_casino.controller.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewBetRequest {
    private String rouletteId;
    private Float amount;
    private Integer betNumber;
    private String colour;
}
