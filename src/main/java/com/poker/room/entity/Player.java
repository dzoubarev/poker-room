package com.poker.room.entity;

import java.util.List;
import java.util.UUID;

import com.poker.room.dto.Card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Player {
    @Id
    @GeneratedValue
    private UUID id;

    private Card[] hand;
    private double chips;
    private boolean isFolded;
    private boolean isAllIn;
    private boolean isBigBlind;
    private boolean isSmallBlind;
    private boolean tookAction;
    private double currBet;
    private Table table;
    
    public Player(Table table){
        hand = new Card[2];
        isFolded = true;
        this.table = table;
        id = UUID.randomUUID();
        tookAction = false;
    }

    public void addToHand(Card card){
        if(hand[0] == null){ hand[0] = card; }
        else if(hand[1] == null){ hand[1] = card;}
        
    }

    public void fold(){
        this.isFolded  = true;
        this.tookAction = true;
    }

    public double raise ( double amount ) throws IllegalArgumentException{
        if(amount > chips){throw new IllegalArgumentException("Not enough chips."); }

        currBet += amount;
        chips -= amount;
        table.addToPot(amount);
        this.tookAction = true;
        return amount;
    }

    public double call (double amount) throws IllegalArgumentException{
        if(amount > chips){throw new IllegalArgumentException("Not enough chips."); }

        currBet += amount;
        chips -= amount;
        table.addToPot(amount);
        this.tookAction = true;
        return amount;
    }

    public double allIn() {
        table.addToPot(chips);
        double amtIn = chips;
        chips = 0;
        this.tookAction = true;
        return amtIn;
        
    }

    public void check(){
        this.tookAction = true;
    }

    public void setBigBlind(boolean isBigBlind){
        this.isBigBlind = isBigBlind;
    }

    public void setSmallBlind(boolean isSmallBlind){
        this.isSmallBlind = isSmallBlind;
    }

    public boolean isFolded(){ return isFolded;}

    public boolean isAllIn(){ return isAllIn;}

    public UUID getId(){ return id; }

    public Table getTable(){ return table; }

    public double getCurrBet(){ return currBet;}

    public void win(int amount){
        this.chips += amount;
    }

    public void reset(){
        hand[0] = null;
        hand[1] = null;
        currBet = 0;
    }

    public boolean hasTakenAction(){
        return this.tookAction;
    }

    public void setCurrBet(double amount){
        this.currBet = amount;
    }

    public void setFolded(boolean folded){
        this.isFolded = folded;
    }
}
