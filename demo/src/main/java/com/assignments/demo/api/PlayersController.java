
package com.assignments.demo.api;

import com.assignments.demo.service.PlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PlayersController {

    private final PlayersService playersService;

    @GetMapping("/players")
    public ResponseEntity<Object> getAllPlayers(){
        return playersService.getAllPlayers();
    }

    @GetMapping("/players/{playerID}")
    public ResponseEntity<Object> getPlayer(@PathVariable String playerID){
        return playersService.getPlayer(playerID);
    }

}
