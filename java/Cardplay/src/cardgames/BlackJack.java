package cardgames;

import player.Player;
import card.DeckOfCards;
import account.AccountDB;

import java.util.Scanner;

public class BlackJack extends CardGame {

    public BlackJack() {

    }
    public BlackJack(AccountDB db, Player host, Player... guestPlayers) {
        this(4, db, host, guestPlayers);
    }

    private BlackJack(int maxPlayerNumber,AccountDB db,  Player host, Player... guestPlayers){
        super(maxPlayerNumber, db, host, guestPlayers);
    }

    @Override
    public void play(CardGameController cgc) {

        if( !cgc.check() ){
            return;
        }
        

        init();

        cgc.firstRoundTakeCard();

        cgc.guestTakeCard();

        cgc.hostTakeCard();

        cgc.everyoneShowCard();

        cgc.showResult();

        return;
    }
    protected void init() {

        cards = new DeckOfCards();
        cards.shuffle();

        guestPlayers.forEach( p -> p.clearCards() );

        host.clearCards();
    }
}