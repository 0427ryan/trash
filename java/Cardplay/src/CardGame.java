import java.util.LinkedList;
import java.util.Scanner;

public class CardGame {
    private final int maxPlayerNumber;
    private Player host;
    private LinkedList<Player> guestPlayers = new LinkedList<>();
    public DeckOfCards cards;

    public CardGame() {
        this(4, null, new Player[]{});
    }

    public CardGame(Player host, Player... guestPlayers) {
        this(4, host, guestPlayers);
    }

    private CardGame(int maxPlayerNumber, Player host, Player... guestPlayers) {
        addGuest(guestPlayers);
        cards = new DeckOfCards();
        this.host = host;
        host.addGame(this);
        this.maxPlayerNumber = maxPlayerNumber;
    }

    public boolean contains(Player player) {
        if(host == player) {
            return true;
        }
        for(Player p : guestPlayers) {
            if(p == player) {
                return true;
            }
        }
        return false;
    }

    public void changeHost(Player host) {
        this.host = host;
    }

    public void addGuest(Player... guestPlayers) {
        for(Player p : guestPlayers) {
            this.addGuest(p);
        }
    }

    public void removeGuest(Player... guestPlayers) {
        for(Player p : guestPlayers) {
            this.removeGuest(p);
        }
    }

    public boolean removeGuest(Player guestPlayer) {
        if( this.guestPlayers.remove(guestPlayer) ) {
            guestPlayer.removeGame(this);
            return true;
        }
        return false;
    }

    public boolean addGuest(Player player) {
        if( guestPlayers.contains(player) &&
                getPlayerNumber() < maxPlayerNumber ) {
            return false;
        }
        this.guestPlayers.add(player);
        player.addGame(this);
        return true;
    }

    public int getPlayerNumber() {
        return guestPlayers.size() + (host == null ? 0 : 1);
    }

    public DeckOfCards getCards() {
        return cards;
    }

    // TODO: Player 拿牌、亮牌
    // TODO: Console print getstring
    public void play() {

        if(host == null) {
            System.out.println("There are no host, game end");
            return;
        }

        init();

        firstRoundTakeCard();

        guestTakeCard();

        hostTakeCard();

        everyoneShowCard();

        showResult();

        return;
    }
    protected void init() {

        cards = new DeckOfCards();
        cards.shuffle();

        for(Player p : guestPlayers) {
            p.clearCards();
        }
        host.clearCards();
    }
    protected void firstRoundTakeCard() {

        host.takeCard();
        for(Player p : guestPlayers) {
            p.takeCard();
        }
        for(Player p : guestPlayers) {
            p.takeCard();

        }
        for(Player p : guestPlayers) {
            System.out.println( p );
        }
        System.out.println();
    }

    protected void guestTakeCard() {
        Scanner in = new Scanner(System.in);
        for(Player p : guestPlayers) {

            System.out.println( p.getName() + " sum: " + p.getSum() );
            System.out.println(p.getName() + " 是否加牌? (y/n) ");
            while( p.getSum() <= 21 && in.nextLine().equalsIgnoreCase("y") ) {
                p.takeCard();

                System.out.println( p.getName() + " sum: " + p.getSum() );
                if(p.getSum() <= 21) {
                    System.out.println(p.getName() + " 是否加牌? (y/n) ");
                }
            }
        }
        System.out.println();
    }

    protected void hostTakeCard() {
        Scanner in = new Scanner(System.in);
        while(host.getSum() < 17) {
            host.takeCard();
        }

        System.out.println( host.getName() + " sum: " + host.getSum() );
        System.out.print( host.getName() + " 是否加牌? (y/n) " );
        while( host.getSum() <= 21 && in.nextLine().equalsIgnoreCase("y") ) {
            host.takeCard(); // 明牌

            System.out.println( host.getName() + " sum: " + host.getSum() );
            if(host.getSum() <= 21) {
                System.out.println( host.getName() + " 是否加牌? (y/n) " );
            }
        }
        System.out.println();
    }

    protected void everyoneShowCard() {
        System.out.println(host);
        for(Player p : guestPlayers) {
            System.out.println(p);
        }
        System.out.println();
    }

    protected void showResult() {
        for(Player p : guestPlayers) {
            System.out.println(p.getName() + " sum = " + p.getSum());
            if(
                ( p.getSum() <= 21 ) &&
                ( host.getSum() > 21 || p.getSum() >
                  host.getSum())
            ) {
                System.out.println(p.getName() + " Win");
            } else {
                System.out.println(p.getName() + " Lose");
            }
        }
    }
}