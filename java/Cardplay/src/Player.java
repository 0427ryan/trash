
import java.util.LinkedList;
import java.util.Scanner;

public class Player {
    private String name;
    private CardGame nowPlaying = null;
    private LinkedList<Card> holdedCard = new LinkedList<>();
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

    public void takeCard(){
        if(nowPlaying != null){
            Card c = nowPlaying.getCards().getFirst();
            holdedCard.add( c );
            System.out.println(name + " get " + c);
            addCardToSum(c);
        }
    }

    public void printCard(){
        for (Card c : holdedCard) {
            System.out.println(c);
        }
    }

    public int getSum(){
        return sum;
    }

    public String getName(){
        return name;
    }

    protected void addCardToSum(Card c){

        if(c.getNumber() >= 10){
            sum += 10;
            return;
        }
        if(c.getNumber() == 1){
            sum += dealWithOne();
            return;
        }
        sum += c.getNumber();
    }

    private int dealWithOne(){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        System.out.println(name);
        System.out.println("This is Ace, choose 1 or 11");
        while(true){
            try{
                int temp;
                temp = in.nextInt();
                if(temp != 1 && temp != 11){
                    System.out.println("Please enter again.");
                    continue;
                }
                sum += temp;
                return sum;
            }catch(Exception e){
                System.out.println("Please enter again.");
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