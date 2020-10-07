package com.casino;

import com.casino.entity.*;
import com.casino.service.CasinoService;
import com.casino.service.GameService;
import com.casino.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CasinoLoader implements ApplicationRunner {
    @Autowired
    private CasinoService casinoService;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;
    private static final Logger LOGGER = Logger.getLogger(CasinoLoader.class.getName());

    public CasinoLoader() {
    }

    public void generateMocks() {

        Casino casinoMock = new Casino();
        Casino casino = casinoService.save(casinoMock);

        //Generate poker games
        GameConfiguration configPokerEasy = new GameConfiguration(GameType.POKER, 30F, 100F, 15F, 60F, 360D);
        GameConfiguration configPokerMedium = new GameConfiguration(GameType.POKER, 15F, 200F, 45F, 120F, 360D);
        GameConfiguration configPokerHard = new GameConfiguration(GameType.POKER, 7F, 300F, 60F, 180F, 360D);
        List<GameConfiguration> pokerConfigurations = new ArrayList();
        pokerConfigurations.add(configPokerEasy);
        pokerConfigurations.add(configPokerMedium);
        pokerConfigurations.add(configPokerHard);
        Game poker = new Game(GameType.POKER, pokerConfigurations, casino);

        //Generate blackjack games
        GameConfiguration configBlackEasy = new GameConfiguration(GameType.BLACK, 25F, 150F, 10F, 40F, 360D);
        GameConfiguration configBlackMedium = new GameConfiguration(GameType.BLACK, 14F, 275F, 25F, 60F, 360D);
        GameConfiguration configBlackHard = new GameConfiguration(GameType.BLACK, 5F, 395F, 40F, 80F, 360D);
        List<GameConfiguration> blackJackConfigurations = new ArrayList();
        blackJackConfigurations.add(configBlackEasy);
        blackJackConfigurations.add(configBlackMedium);
        blackJackConfigurations.add(configBlackHard);
        Game blackjack = new Game(GameType.BLACK, blackJackConfigurations, casino);

        gameService.save(poker);
        gameService.save(blackjack);

        //Generate providers
        Provider bwin = new Provider("BWIN");
        Provider pokerStars = new Provider("POKER_STARS");
        Provider providerBwin = playerService.saveProvider(bwin);
        Provider providerPoker = playerService.saveProvider(pokerStars);

        //Generate players
        Player playerBwin = new Player(250F,"Jugador Bwin",providerBwin, casino);
        Player playerPoker = new Player(500F,"Jugador Poker",providerPoker, casino);

        playerService.savePlayer(playerBwin);
        playerService.savePlayer(playerPoker);

        LOGGER.info("Casino Games:" + gameService.showGames(casino.getId()));
        LOGGER.info("Casino Players:" + playerService.showPlayers(casino.getId()));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.generateMocks();
    }
}
