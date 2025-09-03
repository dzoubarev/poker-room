package com.poker.room.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class Card {
    private int rank;
    private int suit; //0 is club, 1 is spade, 2 is diamond, 3 is heart

    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getSuit(){return suit;}

    public int getRank(){return rank;}

    public String toString(){
        String result = "";

        if(rank <= 10){ 
            result += rank;
        }
        else{
            switch(rank){
                case 11:
                    result+="J";
                    break;

                case 12:
                    result+="Q";
                    break;
                
                case 13:
                    result+="K";
                    break;
                
                case 14:
                    result+="A";
                    break;
            }
        }

        //Add suit to Result
        switch (suit) {
            case 0:
                result += "C";
                break;
            
            case 1:
                result += "S";
                break;
            

            case 2:
                result += "D";
                break;

            case 3:
                result += "H";
                break;
        }

        return result;
        }
    }

