package com.poker.room.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poker.room.entity.Player;
import com.poker.room.entity.Table;

@Service
public class GameEngine {/* 
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

    public void win(Table table, Player player){
        player.win(table.getPot());
    }

    public void startGame(){
        playersIn = List.copyOf(players);
        deck.shuffle();
        dealCardsToPlayers();

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

    public void dealCardsToPlayers() {
        for (Player player : playersIn) {
            player.addToHand(deck.get(currCard++));
            player.addToHand(deck.get(currCard++));
        }
    } */
}
