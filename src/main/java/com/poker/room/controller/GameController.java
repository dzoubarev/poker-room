package com.poker.room.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poker.room.dto.TableDTO;
import com.poker.room.entity.Table;
import com.poker.room.service.GameService;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/add/player/{tableId}")
    public void addPlayer(@PathVariable("tableId") UUID tableId){
        gameService.addPlayer(tableId);
    }

    @PostMapping("/add/table")
    public void createTable(@RequestBody TableDTO table){
        gameService.createTable(table);
        
    }

    @GetMapping("/get-tables")
    public List<TableDTO> getAllTables(){
        return gameService.getAllTables();
    }
}
