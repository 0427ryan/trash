package cardgames;

import player.Player;
import card.DeckOfCards;
import account.AccountDB;

import java.util.List;
import java.util.LinkedList;

public abstract class CardGame {
    
    protected final int maxPlayerNumber;
    protected AccountDB db;
    protected Player host;
    protected List<Player> guestPlayers = new LinkedList<>();
    protected DeckOfCards cards;
    protected CardGameView cv;

    public CardGame() {
        this(4, null, null, new Player[]{});
    }

    public CardGame(AccountDB db, Player host, Player... guestPlayers) {
        this(4, db, host, guestPlayers);
    }

    public CardGame(int maxPlayerNumber,AccountDB db,  Player host, Player... guestPlayers) {
        this.maxPlayerNumber = maxPlayerNumber;
        this.db = db;
        changeHost(host);
        addGuest(guestPlayers);
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
    public void addGuest(Player player) {
        if( this.contains(player) ||
            getPlayerNumber() == maxPlayerNumber ||
            player == null) {
            return;
        }
        this.guestPlayers.add(player);
        player.addGame(this);
        return;
    }

    public void checkAccount(){
        if(host != null && host.getAccountNumber() == null){
            host.setAccountNumber(db.newAccount(host.getName()));
        }
        for(Player p : guestPlayers){
            if(p.getAccountNumber() == null){
                p.setAccountNumber(db.newAccount(p.getName()));
            }
        }
    }
    
    public void removeGuest(Player... guestPlayers) {
        for(Player p : guestPlayers) {
            this.removeGuest(p);
        }
    }

    public void removeGuest(Player guestPlayer) {
        if( this.guestPlayers.remove(guestPlayer) ) {
            guestPlayer.removeGame(this);
        }
        return;
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

    public List<Player> getGuestPlayers(){
        return guestPlayers;
    }

    public abstract void play(CardGameController cgc);
}