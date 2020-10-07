package com.casino.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameSession implements Serializable {

    private Long game;
    private Long player;


    public GameSession() {

    }

    public GameSession(Long game, Long player) {
        this.game = game;
        this.player = player;
    }

    public Long getGame() {
        return game;
    }

    public void setGame(Long game) {
        this.game = game;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "game=" + game +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSession that = (GameSession) o;
        return Objects.equals(game, that.game) &&
                Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, player);
    }
}
