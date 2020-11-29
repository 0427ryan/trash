package cardgames;

import player.Player;

import java.util.Scanner;

public class CardGameController {

    CardGameView cv;
    CardGame c;

    public CardGameController(CardGame c, CardGameView cv){
        this.c = c;
        this.cv = cv;
    }

    public void run(){
        c.play(this);
    }

    public boolean check(){
        if(c.getHost() == null){
            return false;
        }
        c.checkAccount();
        return true;
    }

    protected void firstRoundTakeCard() {
        
        c.getHost().takeCard(cv);

        c.getGuestPlayers().forEach(p -> { p.takeCard(cv); p.takeCard(cv); });

        c.getGuestPlayers().forEach(p -> cv.println(p) );

        cv.println();
    }

    protected void guestTakeCard() {
        Scanner in = new Scanner(System.in);
        for(Player p : c.getGuestPlayers()) {

            cv.println( p.getName() + " sum: " + p.getSum() );
            cv.print( p.getName() + " 是否加牌? (y/n) ");

            while( p.getSum() <= 21 && in.nextLine().equalsIgnoreCase("y") ) {
                p.takeCard(cv);

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

        Scanner in = new Scanner(System.in);
        Player host = c.getHost();

        cv.println( host.getName() + " sum: " + host.getSum() );
        cv.print( host.getName() + " 是否加牌? (y/n) " );

        while( host.getSum() <= 21 && in.nextLine().equalsIgnoreCase("y") ) {
            host.takeCard(cv);

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