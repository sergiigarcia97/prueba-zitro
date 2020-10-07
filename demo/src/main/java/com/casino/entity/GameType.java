package com.casino.entity;

public enum GameType {
    UNKNOWN(""),
    BINGO("VIDEOBINGO"),
    SLOT("SLOT"),
    BLACK("BLACKJACK"),
    POKER("POKER"),
    ROULETTE("RULETA");

    private String type;

    private GameType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
