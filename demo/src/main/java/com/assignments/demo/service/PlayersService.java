package com.assignments.demo.service;

import com.assignments.demo.model.Player;
import org.springframework.http.ResponseEntity;

public interface PlayersService {

    ResponseEntity<Object> getPlayer(String playerID);
    ResponseEntity<Object> getAllPlayers();
    void createPlayer(Player player);
}
