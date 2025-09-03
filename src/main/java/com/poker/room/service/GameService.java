package com.poker.room.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poker.room.dto.TableDTO;
import com.poker.room.entity.Player;
import com.poker.room.entity.Table;
import com.poker.room.repository.TableRepository;

@Service
public class GameService {

    @Autowired
    private TableRepository tableRepository;

    public void createTable(TableDTO table){
        Table newTable = new Table(table);
        tableRepository.save(newTable);
    }

    public void addPlayer(UUID tableId){
        
    }

    public void requestAction(String tableId, Player player){
        
    }

    public List<TableDTO> getAllTables(){
        return tableRepository.findAll().stream().map(TableDTO::new).toList();
    }
}
