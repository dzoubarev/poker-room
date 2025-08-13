package com.poker.room;

public class Main {
    public static void main(String[] args){
        Deck d = new Deck();
        System.out.println(d);
        d.shuffle();
        System.out.println(d);
    }
}
