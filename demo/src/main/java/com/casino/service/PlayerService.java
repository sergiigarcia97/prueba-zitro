package com.casino.service;

import com.casino.entity.Player;
import com.casino.entity.Provider;
import com.casino.repository.PlayerRepository;
import com.casino.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ProviderRepository providerRepository;

    public PlayerService() {
    }

    public Player savePlayer(Player player) {
        if(providerRepository.findByName(player.getProvider().getName()).isPresent()) {
//            providerRepository.save(player.getProvider());
            return playerRepository.save(player);
        }
        return null;
    }

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Player> getByProvider(Provider provider) {
        return playerRepository.findByProvider(provider);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> showPlayers(Long casinoId) {
        return playerRepository.findByCasinoId(casinoId);
    }

}
