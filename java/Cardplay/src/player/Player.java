package player;

import cardgames.CardGame;
import cardgames.CardGameView;
import card.Card;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {

    /*
        this is used to represent a player, contains holded cards, name, the game
        participated in, account number, and the sum points.
    */

    private Integer acctNum;
    private String name;
    private CardGame nowPlaying = null;
    private List<Card> holdedCard = new LinkedList<>();
    private int sum;

    public Player(){
        /*
            default constructor
        */ 
        this.name = "unnamed player";
    }

    public Player(String name){
        /*
            constructor
        */ 
        this.name = name;
    }

    public boolean addGame(CardGame game){
        /*
            this is used to join a game, if there is already a game
            you need to remove the game then you can add the new game.
            (if add game successfully, this return true, else, return false)
        */
        if( nowPlaying == null && game.contains(this)) { //check
            this.nowPlaying = game;
            return true;
        }
        return false;
    }

    public boolean removeGame(CardGame game){
        /*
            this will check game played is or isn't the game put in,
            if it is, remove that and return true, 
            else, do nothing and retuen false.
        */
        if( nowPlaying == game ){
            nowPlaying = null;
            return true;
        }
        return false;
    }

    public void addCard(Card c){
        /*
            this is is used to add new card.
        */
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

    public void setSum(int sum){
        this.sum = sum;
    }

    public int getSum(){
        return sum;
    }
    
    public void clearCards(){
        /*
            this will delete all cards holded, the cards will disappear.
        */
        this.holdedCard.clear();
        sum = 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(name);
        for(Card c : holdedCard){
            sb.append("\n\t").append(c);
        }
        return sb.toString();
    }
}