import java.util.ArrayList;

public class Player {
    String name;
    CardGame nowPlaying = null;
    ArrayList<Card> holdedCard;

    public Player(){
        this.name = "unnamed player";
    }
    public Player(String name){
        this.name = name;
    }
    public boolean addGame(CardGame game){
        if( nowPlaying == null ){
            return false;
        }
        nowPlaying = game;
        game.addPlayer(this);
        return true;
    }
    public boolean throwCard(Card card){
        return holdedCard.remove(card);
    }
}