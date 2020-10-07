package com.casino.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_configuration")
public class GameConfiguration {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private GameType gameType;

    private Float probability;

    private Float reward;

    private Float minBet;

    private Float maxBet;

    private Double duration;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    public GameConfiguration() {
    }

    public GameConfiguration(GameType gameType, Float probability, Float reward, Float minBet, Float maxBet, Double duration) {
        this.gameType = gameType;
        this.probability = probability;
        this.reward = reward;
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Float getReward() {
        return reward;
    }

    public void setReward(Float reward) {
        this.reward = reward;
    }

    public Float getMinBet() {
        return minBet;
    }

    public void setMinBet(Float minBet) {
        this.minBet = minBet;
    }

    public Float getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(Float maxBet) {
        this.maxBet = maxBet;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameConfiguration{" +
                "id=" + id +
                ", gameType=" + gameType +
                ", probability=" + probability +
                ", reward=" + reward +
                ", minBet=" + minBet +
                ", maxBet=" + maxBet +
                ", duration=" + duration +
                ", game=" + game +
                '}';
    }
}
