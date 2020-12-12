package cardgames;

import player.Player;
import card.Card;

import java.util.Scanner;

// this doesn't provide no-argument constructor.
public class BlackJackController {
    //DB is not used,

    CardGameView cv;
    // this is used to show game result and some message while running.
    CardGame c;
    // this is the game being controlled.
    Console in;
    // this is used to get input.

    public BlackJackController(CardGame c, CardGameView cv) {
        /*
            get CardGame and CardGameView then fit them into this,
            make a new Console object, tell it where to get message and
            where to print error message.
        */
        this.c = c;
        this.cv = cv;
        this.in = new Console(new Scanner(System.in), cv);
    }

    protected void playerAddCard(Player p){
        /* give player card and add it to sum,
           if meet number bigger than 10, this will make player's sum added 10,
           if meet Ace, this will call the function dealWithOne. 
        */
        Card card = c.getCards().getFirst();
        p.addCard(card);
        cv.println(p.getName() + " gets " + card);
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

    public int dealWithOne(Player p){
        /*
            deal with Ace,
            this while ask the player who got an Ace use one or eleven 
            to be the number represent the card then return the number player chose
        */
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

    public void run() {
        /*
            this is used to call the method used,
            if Exception occur, this will end the game.
        */
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
        /*
            check if host existed.
        */
        if(c.getHost() == null) {
            return false;
        }
        return true;
    }

    protected void init() {
        /*
            call cardgame to prepare cards, suffle,
            and clear players and host's cards, 
        */
        c.refreshCards();

        c.getCards().shuffle();

        c.getGuestPlayers().forEach( p -> p.clearCards() );

        c.getHost().clearCards();
    }

    protected void firstRoundTakeCard() {
        /*
            host takes one card, then each plaayers takes two cards
        */
        playerAddCard(c.getHost());

        cv.println(c.getHost());

        for(Player p : c.getGuestPlayers()) {
            playerAddCard(p);
            playerAddCard(p);
            cv.println(p);
        }

        cv.println();
    }

    protected void guestTakeCard() {

        /*
            each guests chose whather to take card,
            if the sum of cards overflow, this won't ask, will exit.

        */

        for(Player p : c.getGuestPlayers()) {

            cv.println( p.getName() + " sum: " + p.getSum() );
            cv.print( p.getName() + " 是否加牌? (y/n) ");

            while( p.getSum() <= 21 && in.nextString("[yYnN]").equalsIgnoreCase("y") ) {

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

        /*
            ask host to take card, if the sum larger than 21 this won't ask,
            will exit.
        */

        Player host = c.getHost();

        cv.println( host.getName() + " sum: " + host.getSum() );
        cv.print( host.getName() + " 是否加牌? (y/n) " );

        while( host.getSum() <= 21 && in.nextString("[yYnN]").equalsIgnoreCase("y") ) {
            playerAddCard(host);

            cv.println( host.getName() + " sum: " + host.getSum() );
            if(host.getSum() <= 21) {
                cv.print( host.getName() + " 是否加牌? (y/n) " );
            }
        }
        cv.println();
    }

    protected void everyoneShowCard() {
        /*
            show players and host's detail.
        */
        cv.println(c.getHost());

        c.getGuestPlayers().forEach( cv::println );

        c.getGuestPlayers().forEach( cv::println );

        cv.println();
    }

    protected void showResult() {

        /*
            judge everyone is or isn't win, then show it.
        */

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