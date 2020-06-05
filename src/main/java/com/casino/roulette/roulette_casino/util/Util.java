package com.casino.roulette.roulette_casino.util;

import com.casino.roulette.roulette_casino.model.Colour;

public class Util {
    public static Colour stringToColour(String colour) {
        if (colour.equalsIgnoreCase("RED")) {
            return Colour.RED;
        }
        if (colour.equalsIgnoreCase("BLACK")) {
            return Colour.BLACK;
        }

        return Colour.NONE;
    }
}
