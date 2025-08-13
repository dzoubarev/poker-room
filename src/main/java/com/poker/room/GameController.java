package com.poker.room;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/add/{tableId}")
    public void addPlayer(@PathVariable("tableId") UUID tableId){
        gameService.addPlayer(tableId);
    }
}
