package player;

import cardgames.CardGame;
import cardgames.CardGameView;
import card.Card;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {

    private Integer acctNum;
    private String name;
    private CardGame nowPlaying = null;
    private List<Card> holdedCard = new LinkedList<>();
    private int sum;

    public Player(){ // default constructor 
        this.name = "unnamed player";
    }

    public Player(String name){
        this.name = name;
    }

    public boolean addGame(CardGame game){
        if( nowPlaying == null && game.contains(this)) { //check
            this.nowPlaying = game;
            return true;
        }
        return false;
    }

    public boolean removeGame(CardGame game){
        if( nowPlaying == game ){
            nowPlaying = null;
            return true;
        }
        return false;
    }

    public void addCard(Card c){
        if(nowPlaying != null && c != null){
            holdedCard.add(c);
        }
    }

    public void printCard(CardGameView cv){
        for (Card c : holdedCard) {
            System.out.println(c);
        }
    }

    public void setAccountNumber(Integer acctNum){
        this.acctNum = acctNum;
    }

    public Integer getAccountNumber(){
        return acctNum;
    }

    public String getName(){
        return name;
    }


    public int getSum(){
        return sum;
    }

    public void setSum(int sum){
        this.sum = sum;
    }
    
    public void clearCards(){
        this.holdedCard.clear();
        sum = 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(name);
        for(Card c : holdedCard){
            sb.append("\n\t").append(c);
        }
        return sb.toString();
    }
}