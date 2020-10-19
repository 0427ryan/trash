import java.util.ArrayList;

public class CardGame {
	public final int maxPlayerNumber;
	ArrayList<Player> playerList = new ArrayList<>();
	
	public CardGame(int maxPlayerNumber, Player... playerList) {
		addPlayer(playerList);
		this.maxPlayerNumber = maxPlayerNumber;
	}
	public void addPlayer(Player... playerList) {
		for(Player p : playerList){
			this.addPlayer(p);
		}
	}
	public boolean addPlayer(Player player) {
		if( playerList.contains(player) && 
			getPlayerNumber() < maxPlayerNumber ) {
			return false;
		}
		this.playerList.add(player);
		player.addGame(this);
		return true;
	}
	public int getPlayerNumber(){
		return playerList.size();
	}
	public void play(){
		//
	} 
}