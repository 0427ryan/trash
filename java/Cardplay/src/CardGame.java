import java.util.LinkedList;

public abstract class CardGame {
    
    protected final int maxPlayerNumber;
    protected Player host;
    protected LinkedList<Player> guestPlayers = new LinkedList<>();
    protected DeckOfCards cards;
    protected CardGameView cv;

    public CardGame() {
        this(4, null, new Player[]{});
    }

    public CardGame(Player host, Player... guestPlayers) {
        this(4, host, guestPlayers);
    }

    public CardGame(int maxPlayerNumber, Player host, Player... guestPlayers) {
        addGuest(guestPlayers);
        cards = new DeckOfCards();
        changeHost(host);
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
        if(this.host != null){
            this.host.removeGame(this);
        }
        this.host = host;
        host.addGame(this);
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

    public Player getHost(){
        return host;
    }

    public LinkedList<Player> getGuestPlayers(){
        return guestPlayers;
    }

    public abstract void play(CardGameController cgc);
}