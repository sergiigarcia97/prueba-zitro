package com.casino.service;

import com.casino.entity.*;
import com.casino.repository.CasinoRepository;
import com.casino.repository.MoveRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasinoService {
    @Autowired
    private CasinoRepository casinoRepository;
    @Autowired
    private MoveRepository moveRepository;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;


    public CasinoService() {
    }

    public Casino getById(Long idCasino) {
        return casinoRepository.findById(idCasino).get();
    }

    /*public List<Game> showGames(Long casinoId) {
        return casinoRepository.findById(casinoId).get().getGames();
    }

    public List<Player> showPlayers(Long casinoId) {
        return casinoRepository.findById(casinoId).get().getPlayers();
    }*/

    public List<GameConfiguration> showGameConfigurationOfGametype(Long idCasino, Game game) {
        return gameService.getGameConfigurationByGame(game);
    }

    public Casino save(Casino casino) {
        /*casino.getPlayers().forEach(player -> {
            player.setCasino(casino);
            playerService.savePlayer(player);
        });
        casino.getGames().forEach(game-> {
            game.setCasino(casino);
            gameService.save(game);
        });*/
        return casinoRepository.save(casino);
    }

}