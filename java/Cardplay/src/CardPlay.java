import java.util.ArrayList;

public class CardPlay {
	public int playerNumber;
	ArrayList<Player> playerList = new ArrayList<>();
	
	public CardPlay(Player... playerList){
		for(Player player : playerList){
			addPlayer(player);
		}
		this.playerNumber = playerList.length();
	}

	public boolean addPlayer(Player player){
		if(playerList.contains(player)){
			return false;
		}
		this.playerList.add(player);
		return true;
	}
}