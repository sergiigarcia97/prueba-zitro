package com.casino.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private GameType type;

    @OneToMany
    private List<GameConfiguration> gameConfigurations;

    @ManyToOne
    @JoinColumn(name = "casino_id", referencedColumnName = "id")
    private Casino casino;

    public Game() {
    }

    public Game(GameType type, List<GameConfiguration> gameConfigurations, Casino casino) {
        this.type = type;
        this.gameConfigurations = gameConfigurations;
        this.casino = casino;
    }

    public Long getId() {
        return id;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public List<GameConfiguration> getGameConfigurations() {
        return gameConfigurations;
    }

    public void setGameConfigurations(List<GameConfiguration> gameConfigurations) {
        this.gameConfigurations = gameConfigurations;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", type=" + type +
                ", gameConfigurations=" + gameConfigurations +
                ", casino=" + casino +
                '}';
    }
}
