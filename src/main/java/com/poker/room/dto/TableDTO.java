package com.poker.room.dto;

import java.util.UUID;

import com.poker.room.entity.Table;

public class TableDTO {
    private int numPlayers;
    private int maxPlayers;

    private double smallBlind;
    private double bigBlind;

    private String roomName;
    private UUID roomID;
    private String password;

    public TableDTO(Table table){
        this.numPlayers = table.getPlayers().size();
        this.maxPlayers = table.getMaxPlayers();
        this.bigBlind = table.getBigBlind();
        this.smallBlind = table.getSmallBlind();
        this.roomName = table.getName();
        this.roomID = table.getId();
        this.password = table.getPassword();
    }

    public int getMaxPlayers() { return this.maxPlayers; }

    public double getSmallBlind() { return this.smallBlind; }

    public double getBigBlind() { return this.bigBlind; }

    public String getRoomName() { return this.roomName; }

    public String getPassword() { return this.password; }
}
