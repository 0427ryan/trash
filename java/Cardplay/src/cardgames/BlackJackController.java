package cardgames;

import player.Player;
import card.Card;

import java.util.Scanner;

public class BlackJackController {  //DB is not used,

    CardGameView cv;
    CardGame c;
    Console in;

    public BlackJackController(CardGame c, CardGameView cv) {
        this.c = c;
        this.cv = cv;
        this.in = new Console(new Scanner(System.in), cv);
    }

    public int dealWithOne(Player p){
        int sum = 0;
        cv.println(p.getName());
        cv.println("This is Ace, choose 1 or 11");
        while(true){
            sum = in.nextInt();
            if(sum != 1 && sum != 11){
                cv.println("Please enter 1 or 11.");
                continue;
            }
            return sum;
        }
    }

    protected void playerAddCard(Player p){
        Card card = c.getCards().getFirst();
        p.addCard(card);
        if(card.getNumber() >= 10){
            p.setSum( p.getSum() + 10 );
            return;
        }
        if(card.getNumber() == 1){
            p.setSum( p.getSum() + dealWithOne(p) );
            return;
        }
        p.setSum( p.getSum() + card.getNumber() );
    }

    public void run() {
        try{
            if( !checkOK() ) {
                return;
            }
            init();

            firstRoundTakeCard();

            guestTakeCard();

            hostTakeCard();

            everyoneShowCard();

            showResult();

            return;
        }catch(Exception e){
            cv.println("Game ended.");
        }
    }

    public boolean checkOK() {
        if(c.getHost() == null) {
            return false;
        }
        c.checkAccount();
        return true;
    }

    protected void init() {

        c.refreshCards();

        c.getCards().shuffle();

        c.getGuestPlayers().forEach( p -> p.clearCards() );

        c.getHost().clearCards();
    }

    protected void firstRoundTakeCard() {
        playerAddCard(c.getHost());
        cv.println(c.getHost());
        for(Player p : c.getGuestPlayers()){
            playerAddCard(p);
            playerAddCard(p);
            cv.println(p);
        }

        cv.println();
    }

    protected void guestTakeCard() {
        Scanner in = new Scanner(System.in);
        for(Player p : c.getGuestPlayers()) {

            cv.println( p.getName() + " sum: " + p.getSum() );
            cv.print( p.getName() + " 是否加牌? (y/n) ");

            while( p.getSum() <= 21 && in.nextLine().equalsIgnoreCase("y") ) {
                

                playerAddCard(p);

                cv.println( p.getName() + " sum: " + p.getSum() );
                if(p.getSum() <= 21) {
                    cv.print(p.getName() + " 是否加牌? (y/n) ");
                }
            }
            cv.println();
        }
        cv.println();
    }

    protected void hostTakeCard() {

        Player host = c.getHost();

        cv.println( host.getName() + " sum: " + host.getSum() );
        cv.print( host.getName() + " 是否加牌? (y/n) " );

        while( host.getSum() <= 21 && in.nextLine().equalsIgnoreCase("y") ) {
            playerAddCard(host);

            cv.println( host.getName() + " sum: " + host.getSum() );
            if(host.getSum() <= 21) {
                cv.print( host.getName() + " 是否加牌? (y/n) " );
            }
        }
        cv.println();
    }

    protected void everyoneShowCard() {
        cv.println(c.getHost());

        c.getGuestPlayers().forEach( p -> cv.println(p) );

        c.getGuestPlayers().forEach( p -> cv.println(p) );

        cv.println();
    }

    protected void showResult() {
        Player host = c.getHost();
        for(Player p : c.getGuestPlayers()) {

            cv.println(p.getName() + " sum = " + p.getSum());
            if(  p.getSum() <= 21 &&
                    (host.getSum() > 21 || p.getSum() > host.getSum()) ) {

                cv.println(p.getName() + " Win");
            } else {
                cv.println(p.getName() + " Lose");
            }
        }
    }
}