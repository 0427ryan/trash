import java.util.Scanner;

public class BlackJack extends CardGame {

    public BlackJack() {

    }
    public BlackJack(Player host, Player... guestPlayers) {
        this(4, host, guestPlayers);
    }

    private BlackJack(int maxPlayerNumber, Player host, Player... guestPlayers){
        super(maxPlayerNumber, host, guestPlayers);
    }
    @Override
    public void play(CardGameController cgc) {

        if(host == null) {
            System.out.println("There are no host, game end");
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