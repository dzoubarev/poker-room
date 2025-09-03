package com.poker.room.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.poker.room.dto.Card;
import com.poker.room.dto.Deck;
import com.poker.room.dto.TableDTO;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Table {
    
    @Id
    @GeneratedValue
    private UUID id;

    //Player related
    private List<Player> players = new ArrayList<Player>();
    private int currPlayer = 0;
    
    //Table attributes
    private String roomName;
    private int maxSize;
    private double pot;
    private double bigBlind;
    private double smallBlind;
    private  String password;

    //Card related
    private Deck deck = new Deck();
    private int currCard = 0;
    @ElementCollection
    private List<Card> community = new ArrayList<Card>(); 

    //Betting or round related
    private int round;
    private double currBet = 0;



    public Table(TableDTO table){
        this.maxSize = table.getMaxPlayers();
        this.bigBlind = table.getBigBlind();
        this.smallBlind = table.getSmallBlind();
        this.roomName = table.getRoomName();
        this.pot = 0;
        this.currPlayer = 0;
        this.password = table.getPassword();
    }
    
    public void addPlayer(Player player){
        if(players.size() + 1 > maxSize){
            throw new IllegalArgumentException("Max players already reached.");
        }

        players.add(player);
    }


    public void addToPot(double amount) {
        pot += amount;
    }

    public double getCurrBet(){
        return currBet;
    }

    public double getPot(){
        return pot;
    }

    public void setCurrBet(double currBet){
        this.currBet = currBet;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public String getName(){ return this.roomName; }

    public int getMaxPlayers(){ return this.maxSize; }

    public double getBigBlind(){ return this.bigBlind; }

    public double getSmallBlind(){ return this.smallBlind; }

    public UUID getId(){ return this.id; }

    public String getPassword(){return this.password;}

}
