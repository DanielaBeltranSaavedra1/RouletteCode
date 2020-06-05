package com.casino.roulette.roulette_casino.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BetDto {
    private float totalAmount;
    private String clientId;
    private String colour;
    private int number;
    private String win;
}
