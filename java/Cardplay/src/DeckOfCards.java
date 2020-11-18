import java.security.SecureRandom;
import java.util.LinkedList;

public class DeckOfCards {
    LinkedList<Card> cards;
    int index;
    public DeckOfCards(){
        cards = new LinkedList<>();
        int i = 0;
        for(Kind k : Kind.values()){
            for(Num n : Num.values()){
                cards.add(new Card(n, k));
                i++;
            }
        } 
    }
    public void shuffle(){
        SecureRandom random = new SecureRandom();
        for(int i = 0 ; i < 100 ; i++){
            Card c = cards.get(random.nextInt(52));
            cards.remove(c);
            cards.addFirst(c);
        }
    }
    public Card getFirst(){
        Card c = cards.getFirst();
        cards.remove(c);
        return c;
    }
}