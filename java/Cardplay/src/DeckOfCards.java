import java.security.SecureRandom;

public class DeckOfCards {
    Card[] cards;
    public DeckOfCards(){
        cards = new Card[52];
        int i = 0;
        for(Kind k : Kind.values()){
            for(Num n : Num.values()){
                cards[i] = new Card(n, k);
                i++;
            }
        } 
    }
    public void shuffle(){
        SecureRandom random = new SecureRandom();
        Card c = cards[0];
        for(int i = 0 ; i < 100 ; i++){
            int now = random.nextInt(52);
            cards[0] = cards[now];
            cards[now] = c;
            c = cards[0];
        }
    }
}