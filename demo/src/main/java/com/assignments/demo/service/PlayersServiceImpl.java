package com.assignments.demo.service;

import com.assignments.demo.model.Player;
import com.assignments.demo.repository.PlayersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService{

    private final PlayersRepository playersRepository;

    @Override
    public ResponseEntity<Object> getPlayer(String playerID) {
        Optional<Player> player = playersRepository.findById(playerID);

        return player.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(player.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllPlayers() {
        List<Player> allPlayers = playersRepository.findAll();
        return allPlayers.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }

    @Override
    public void createPlayer(Player player) {
        playersRepository.save(player);
    }
}
