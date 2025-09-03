package com.poker.room;

import com.poker.room.dto.Deck;

public class Main {
    public static void main(String[] args){
        Deck d = new Deck();
        System.out.println(d);
        d.shuffle();
        System.out.println(d);
    }
}
