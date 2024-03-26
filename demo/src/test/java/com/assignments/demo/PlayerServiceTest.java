package com.assignments.demo;

import com.assignments.demo.model.Player;
import com.assignments.demo.repository.PlayersRepository;
import com.assignments.demo.service.PlayersService;
import com.assignments.demo.service.PlayersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerServiceTest {
    @Mock
    PlayersRepository playersRepository;
    PlayersService playersService;
    Player player1;
    Player player2;

    @BeforeEach
    void init(){
        playersRepository = Mockito.mock(PlayersRepository.class);
        playersService = Mockito.spy(new PlayersServiceImpl(playersRepository));
        player1 = createPlayer(1);
        player2 = createPlayer(2);
        List<Player> playersList = new ArrayList<>();
        playersList.add(player1);
        playersList.add(player2);
        Mockito.when(playersRepository.findById("#1")).thenReturn(Optional.ofNullable(player1));
        Mockito.when(playersRepository.findById("#2")).thenReturn(Optional.ofNullable(player1));
        Mockito.when(playersRepository.findAll()).thenReturn(playersList);

    }

    @Test
    void getPlayerTest(){
        ResponseEntity<Object> resultPlayer = playersService.getPlayer("#1");
        assertEquals(HttpStatus.OK, resultPlayer.getStatusCode());
        assertEquals(player1, resultPlayer.getBody());
    }

    @Test
    void getPlayerTest_noContent(){
        ResponseEntity<Object> resultPlayer = playersService.getPlayer("#3");
        assertEquals(HttpStatus.NO_CONTENT, resultPlayer.getStatusCode());
        assertNull(resultPlayer.getBody());
    }

    @Test
    void getAllPlayersTest(){
        ResponseEntity<Object> resultEntity = playersService.getAllPlayers();
        assertEquals(HttpStatus.OK, resultEntity.getStatusCode());

        boolean checkType = resultEntity.getBody() instanceof List;
        assertTrue(checkType);
        List<Player> resultList = (List<Player>) resultEntity.getBody();

        assertNotNull(resultList);
        assertEquals(2, resultList.size());
        assertEquals(player1, resultList.get(0));
        assertEquals(player2, resultList.get(1));
    }

    private Player createPlayer(int index) {
        Player player = new Player();
        player.setPlayerID("#" + index);
        player.setBirthYear(1850);
        return player;
    }
}
