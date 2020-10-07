package com.casino.service;

import com.casino.entity.Game;
import com.casino.entity.GameConfiguration;
import com.casino.entity.GameType;
import com.casino.repository.GameConfigurationRepository;
import com.casino.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameConfigurationRepository gameConfigurationRepository;

    public GameService() {
    }

    public Game save(Game game) {
        game.getGameConfigurations().forEach((gameConfiguration) -> {
            gameConfigurationRepository.save(gameConfiguration);
        });
        return gameRepository.save(game);
    }

    public List<Game> getByGametype(GameType gameType) {
        if(!gameRepository.findByType(gameType).isEmpty()) {
            return gameRepository.findByType(gameType);
        }
        return null;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public List<GameConfiguration> getGameConfigurationByGame(Game game) {
        return gameRepository.findGameconfigurationByType(game.getType());
    }

    public Game getGameById(Long idGame) {
        if(gameRepository.findById(idGame).isPresent()) {
            return gameRepository.findById(idGame).get();
        }
        return null;
    }

    public List<Game> showGames(Long casinoId) {
        return gameRepository.findByCasinoId(casinoId);
    }
}