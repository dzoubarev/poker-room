package com.poker.room;

import java.util.List;
import java.util.UUID;



public class Player {
    private UUID id;

    private Card[] hand;
    private int chips;
    private boolean isFolded;
    private boolean isAllIn;
    private boolean isBigBlind;
    private boolean isSmallBlind;
    private int currBet;
    private Table table;
    
    public Player(Table table){
        hand = new Card[2];
        isFolded = true;
        this.table = table;
        id = UUID.randomUUID();
    }

    public void addToHand(Card card){
        if(hand[0] == null){ hand[0] = card; }
        else if(hand[1] == null){ hand[1] = card;}
        
    }

    public void fold(){
        this.isFolded  = true;
    }

    public void raise ( int amount ) throws IllegalArgumentException{
        if(amount > chips){throw new IllegalArgumentException("Not enough chips."); }
        currBet += amount;
        chips -= amount;
        table.addToPot(amount);
    }

    public void call (int amount) throws IllegalArgumentException{
        if(amount > chips){throw new IllegalArgumentException("Not enough chips."); }
        currBet += amount;
        chips -= amount;
        table.addToPot(amount);
    }

    public void allIn() {
        table.addToPot(chips);
        chips = 0;
        allIn();
    }

    public void check(){
        
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

    public int getCurrBet(){ return currBet;}

    public void win(int amount){
        this.chips += amount;
    }

    public void reset(){
        hand[0] = null;
        hand[1] = null;
        currBet = 0;
    }

}
