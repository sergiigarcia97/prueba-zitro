package com.casino.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class GameData {

    @EmbeddedId
    private GameSession gameSession;

    @OneToMany
    private List<Move> moves;

    private Date duration;

    @ManyToOne
    @JoinColumn(name = "casino_id", referencedColumnName = "id")
    private Casino casino;

    public GameData() {

    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "gameSession=" + gameSession +
                ", moves=" + moves +
                ", casino=" + casino +
                ", duration=" + duration +
                '}';
    }
}
