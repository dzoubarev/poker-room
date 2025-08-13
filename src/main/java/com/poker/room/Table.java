package com.poker.room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Table {
    private UUID id;

    //Player related
    private List<Player> players = new ArrayList<Player>();
    private List<Player> playersIn = new ArrayList<Player>();
    private int currPlayer = 0;
    
    //Table attributes
    private int maxSize;
    private int pot;
    private int bigBlind;

    //Card related
    private Deck deck;
    private int currCard = 0;
    private List<Card> community = new ArrayList<Card>(); 

    //Betting or round related
    private int round;
    private int currBet = 0;


    public Table(int maxSize, int bigBlind){
        id = UUID.randomUUID();
        this.maxSize = maxSize;
        this.pot = 0;
        deck = new Deck();
        this.bigBlind = bigBlind;
    }
    
    public void addPlayer(Player player){
        if(players.size() + 1 > maxSize){
            throw new IllegalArgumentException("Max players already reached.");
        }

        players.add(player);
    }

    public void nextAction(){
        if(playersIn.size() == 1){
            this.win(playersIn.get(0));
        }
        else{
            if(playersIn.get(currPlayer).getCurrBet() == this.currBet){ 
                nextRound();
            }
        }
    }

    public void nextRound(){
        if(round == 3){
            showDown();
        }
        else{
            round++;

            switch(round){
                case 1: 
                    flop();
                    break;
                case 2:
                case 3:
                    turnOrRiver();
                    break;
            }
        }
    }

    public void showDown(){

    }

    public void win(Player player){
        player.win(pot);
    }

    public void startGame(){
        playersIn = List.copyOf(players);
        deck.shuffle();
        deck.deal(players);
    }

    public void addToPot(int amount) {
        pot += amount;
    }

    public void flop(){
        for(int i=0; i<3; i++){
            currCard+=2;
            community.add(deck.get(currCard));
        }
    }

    public void turnOrRiver(){

    };
}
