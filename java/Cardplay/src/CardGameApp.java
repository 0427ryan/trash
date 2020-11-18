
public class CardGameApp {
    public static void main(String[] args){
        new CardGame(
            new Player("host"),
            new Player("guess 1"),
            new Player("guess 2"),
            new Player("guess 3")
        ).play();
    }    
}
