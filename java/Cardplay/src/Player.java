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
        if( nowPlaying == null && !game.addPlayer()){
            return false;
        }
        this.nowPlaying = game;
        return true;
    }

    public boolean removeGame(CardGame game){
        if( nowPlaying == game ){
            nowPlaying = null;
            return true;
        }
        return false;
    }

    public boolean printCard(){
        
    }
}