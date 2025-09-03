package com.poker.room.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Embeddable;

@Embeddable
public class Deck {
    private List<Card> deck;
    
    public Deck(){
        deck = new ArrayList<Card>();

        for(int i=2; i<15; i++){
            for(int j=0; j<4; j++){
                deck.add(new Card(i,j));
            }
        }
    }

    public String toString(){
        return deck.toString();
    }

    public Card get( int index ){
        return deck.get(index);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}
