package com.casino.repository;

import com.casino.entity.Casino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasinoRepository extends JpaRepository<Casino, Long> {
}
