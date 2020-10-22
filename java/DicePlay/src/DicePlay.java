
public class DicePlay {

    public DicePlay(){
    }
    
    public void play(){

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        int sum = d1.getNextNumber() + d2.getNextNumber();

        System.out.println("d1:" + d1.getState());
        System.out.println("d2:" + d2.getState());
        
        if(sum == 2 || sum == 3 || sum == 12){
            System.out.println("lose");
            return;
        }
        if(sum == 7 || sum == 11){
            System.out.println("win");
            return;
        }
        while(sum != 7){
            sum = d1.getNextNumber() + d2.getNextNumber();
            System.out.println("d1:" + d1.getState());
            System.out.println("d2:" + d2.getState());
            if(d1.getState() == d2.getState()){
                System.out.println("win");
                return;
            }
        }
        System.out.println("lose");
    }

}