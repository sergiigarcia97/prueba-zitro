package com.casino.repository;

import com.casino.entity.GameConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameConfigurationRepository extends JpaRepository<GameConfiguration, Long> {
}
