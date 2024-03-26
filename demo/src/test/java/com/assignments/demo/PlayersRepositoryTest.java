package com.assignments.demo;

import com.assignments.demo.model.Player;
import com.assignments.demo.repository.PlayersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PlayersRepositoryTest {

    @Autowired
    PlayersRepository repo;
    Player player1;
    Player player2;


    @BeforeEach
    void init(){
        player1 = createPlayer(1);
        player2 = createPlayer(2);
        repo.save(player1);
        repo.save(player2);

    }

    @Test
    public void testPersistenceHasData_getSingle(){
        Optional<Player> resultPlayer = repo.findById("#1");
        assertTrue(resultPlayer.isPresent());
        assertEquals(player1, resultPlayer.get());
    }

    @Test
    public void testPersistenceHasData_getAll(){
        List<Player> resultPlayers = repo.findAll();
        assertEquals(2, resultPlayers.size());
        assertEquals(player1, resultPlayers.get(0));
        assertEquals(player2, resultPlayers.get(1));
    }

    @Test
    public void testPersistence_noContent(){
        Optional<Player> resultPlayer = repo.findById("#3");
        assertTrue(resultPlayer.isEmpty());
    }

    private Player createPlayer(int index) {
        Player player = new Player();
        player.setPlayerID("#" + index);
        player.setBirthYear(1850);

        return player;
    }

    @AfterEach
    void tearDown(){
        repo.deleteAll();
    }




}
