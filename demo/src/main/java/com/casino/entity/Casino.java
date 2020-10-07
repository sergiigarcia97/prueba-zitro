package com.casino.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "casino")
public class Casino {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "casino")
    private List<Player> players;
    @OneToMany(mappedBy = "casino")
    private List<Game> games;
//    @OneToMany
//    private List<GameData> gameData;

    public Casino() {
    }


    public Long getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

//    public List<GameData> getGameData() {
//        return gameData;
//    }

//    public void setGameData(List<GameData> gameData) {
//        this.gameData = gameData;
//    }

    @Override
    public String toString() {
        return "Casino{" +
                "id=" + id +
                ", players=" + players +
                ", games=" + games +
                '}';
    }
}
