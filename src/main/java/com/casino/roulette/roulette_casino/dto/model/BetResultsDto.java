package com.casino.roulette.roulette_casino.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BetResultsDto {
    private String rouletteId;
    private int winnerNumber;
    private String winnerColour;
    private List<BetDto> betList;
}
