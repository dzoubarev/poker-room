package com.poker.room.service;

import java.util.List;

import com.poker.room.entity.Player;
import com.poker.room.entity.Table;

public class BettingManager {
    int bigBlind,smallBlind;
    Table table;

    public BettingManager(int bigBlind, int smallBlind, Table table){
        this.bigBlind = bigBlind;
        this.smallBlind = smallBlind;
        this.table = table;
    }
    
    public void startRound(List<Player> playersIn){
        int currPlayer = 0;
        int currBet = 0;
        if(this.table.getPot() == 0){
            playersIn.get(0).raise(smallBlind);
            playersIn.get(1).raise(bigBlind);
            table.setCurrBet(bigBlind);
            currPlayer = 2 % playersIn.size();
            currBet = bigBlind;
        }

        while(!bettingRoundOver(playersIn, currBet)){
            
            currPlayer++;
        }


    }

    public void processAction(Table table, Player player, String action, double amount) {
        switch (action.toLowerCase()) {
            case "check":
                player.check();
                break;
            case "call":
                double callAmount = table.getCurrBet() - player.getCurrBet();
                player.call(callAmount);
                player.setCurrBet(table.getCurrBet());
                table.addToPot(callAmount);
                break;
            case "bet":
                if (amount == 0.0) throw new IllegalArgumentException("Bet amount required");
                table.setCurrBet(amount);
                player.raise(amount);
                player.setCurrBet(amount);
                table.addToPot(amount);
                break;
            case "fold":
                player.setFolded(true);
                break;
        }
    }


    public boolean bettingRoundOver(List<Player> playersIn, int currBet){
        if(playersIn.size() == 1){return true;}

        for(Player player: playersIn){
            if(player.getCurrBet() != currBet){return false;}
            if(!player.hasTakenAction()){return false;}
        }

        return true;
    }

    public void resetBets(List<Player> playersIn){
        for(Player player : playersIn){
            player.setCurrBet(0);
        }
    }

    
}
