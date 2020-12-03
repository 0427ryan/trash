import cardgames.*;
import player.Player;
import account.AccountDB;

public class CardGameApp {
    public static void main(String[] args){
        new CardGameController(
            new BlackJack(
                new AccountDB(),
                new Player("host"),
                new Player("guess 1"),
                new Player("guess 2"),
                new Player("guess 3")
            ),
            new CardGameView()
        ).run();
    }    
}
