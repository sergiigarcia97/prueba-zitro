package com.casino.repository;

import com.casino.entity.Game;
import com.casino.entity.GameConfiguration;
import com.casino.entity.GameType;
import java.util.List;

import com.casino.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByType(GameType gameType);

    List<GameConfiguration> findGameconfigurationByType(GameType gameType);

    List<Game> findByCasinoId(Long casinoId);
}
