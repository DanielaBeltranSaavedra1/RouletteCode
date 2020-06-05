package com.casino.roulette.roulette_casino.controller.api.request.validation;

import com.casino.roulette.roulette_casino.controller.api.request.NewBetRequest;
import com.casino.roulette.roulette_casino.controller.api.request.NewClientRequest;

public class RequestValidation {
    public static boolean isValidNewBetRequest(NewBetRequest newBetRequest) {
        return newBetRequest.getRouletteId() != null &&
                newBetRequest.getAmount() != null &&
                (newBetRequest.getColour() != null || newBetRequest.getBetNumber() != null);
    }

    public static boolean isValidNewClientRequest(NewClientRequest newClientRequest) {
        return newClientRequest.getName() != null &&
                newClientRequest.getBalance() != null;
    }
}
