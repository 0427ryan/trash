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

    public Player(){
        this.name = "unnamed player";
    }
    public Player(String name){
        this.name = name;
    }
    public boolean addGame(CardGame game){
        if( nowPlaying == null && game.contains(this)) {
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

    public void takeCard(CardGameView cv){
        if(nowPlaying != null){
            Card c = nowPlaying.getCards().getFirst();
            holdedCard.add( c );
            cv.println(name + " get " + c);
            addCardToSum(c, cv);
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

    public int getSum(){
        return sum;
    }

    public String getName(){
        return name;
    }

    protected void addCardToSum(Card c, CardGameView cv){

        if(c.getNumber() >= 10){
            sum += 10;
            return;
        }
        if(c.getNumber() == 1){
            sum += dealWithOne(cv);
            return;
        }
        sum += c.getNumber();
    }

    private int dealWithOne(CardGameView cv){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        cv.println(name);
        cv.println("This is Ace, choose 1 or 11");
        while(true){
            try{
                int temp;
                temp = in.nextInt();
                if(temp != 1 && temp != 11){
                    cv.println("Please enter again.");
                    continue;
                }
                sum += temp;
                return sum;
            }catch(Exception e){
                cv.println("Please enter again.");
                in.nextLine();
            }
        }
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