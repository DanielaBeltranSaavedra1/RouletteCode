package com.casino.roulette.roulette_casino.model;

public enum Colour {
    RED("RED"),
    BLACK("BLACK"),
    NONE("NONE_VAL");

    public final String value;

    private Colour(String value) {
        this.value = value;
    }
}
