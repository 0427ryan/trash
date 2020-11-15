import java.util.LinkedList;
import java.util.Scanner;

public class CardGame {
	private final int maxPlayerNumber;
	private Player host;
	private LinkedList<Player> guestPlayers = new LinkedList<>();
	
	public CardGame() {
		this(4, null, new Player[]);
	}

	public CardGame(Player... guestPlayers) {
		this(4, null, guestPlayers);
	}

	public CardGame(int maxPlayerNumber, Player host, Player... guestPlayers) {
		addPlayer(guestPlayers);
		this.maxPlayerNumber = maxPlayerNumber;
	}

	public void changeHost(Player host){
		this.host = host;
	}

	public void addGuest(Player... guestPlayers) {
		for(Player p : guestPlayers){
			this.addGuest(p);
		}
	}

	public void removeGuest(Player... guestPlayers) {
		for(Player p : guestPlayers){
			this.removeGuest(p);
		}
	}

	public boolean removeGuest(Player guestPlayer) {
		if( this.guestPlayers.remove(guestPlayer) ){
			guestPlayer.removeGame(this);
			return true;
		}
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

	public int getPlayerNumber(){
		return guestPlayers.size() + (host == null ? 0 : 1);
	}

	// TODO: Player 暗牌、明牌、拿牌、亮牌
	// TODO: Console print getstring
	public void play(){

		if(host == null){
			System.out.println("沒有莊家，遊戲結束。");
			return;
		}

		cards.shuffle();

		firstRoundGetCard();

		guestGetCard();

		hostGetCard();

		everyoneShowCard();

		showResult();
		
		return;
	}

	protected void firstRoundGetCard(){
		host.getCard();
		for(Player p : guestPlayers){
			p.getCard();
		}
		for(Player p : guestPlayers){
			p.getCard();
		}
		System.out.println();
	}

	protected void guestGetCard(){
		for(Player p : guestPlayers){
			while( ConSole.getString( p.getName() + " 是否加牌? (y/n) " )
						  .equalsIgnoreCase()("y") 
			){
				p.getCard(); // 明牌
			}
		}
		System.out.println();
	}

	protected void hostGetCard(){
		while(host.gttSum() < 17){
			host.getCard();
		}
		while( in.getString( p.getName() + " 是否加牌? (y/n) " )
				 .equalsIgnoreCase()("y") 
		){
			host.getCard(); // 明牌
		}
		System.out.println();
	}

	protected void everyoneShowCard(){
		host.printCard();
		for(Player p : guestPlayers){
			p.printCard();
		}
		System.out.println();
	}

	protected void showResult(){
		for(Player p : guestPlayers){
			System.out.print(p.getName() + p.getSum());
			if( 
				( p.getSum() <= 21 ) &&
				( m.getSum() > 21 || p.getSum() < host.getSum())
			){
				System.out.println(p.getName() + " Win");
			}
				System.out.println(p.getName() + "Lose");
		}
	}
}