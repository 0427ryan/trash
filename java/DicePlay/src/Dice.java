import java.security.SecureRandom;

public class Dice {
    
    private int state;

    public Dice(){
        this.throwDice();
    }
    public void throwDice(){
        state = new SecureRandom().nextInt(6) + 1;
    }
    public int getNextNumber(){
        throwDice();
        return state;
    }
    public int getState(){
        return state;
    }
}