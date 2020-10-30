
public class Craps {

    public Craps() {
    }

    public void play() {

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        int sum = d1.getNextNumber() + d2.getNextNumber();

        System.out.print("d1:" + d1.getState() + "  ");
        System.out.println("d2:" + d2.getState());
        System.out.println("sum:" + sum);
        System.out.println();

        if(sum == 2 || sum == 3 || sum == 12) {
            System.out.println("lose");
            return;
        }
        if(sum == 7 || sum == 11) {
            System.out.println("win");
            return;
        }
        int lastSum;
        while(sum != 7) {
            lastSum = sum;
            sum = d1.getNextNumber() + d2.getNextNumber();

            System.out.print("d1:" + d1.getState() + "  ");
            System.out.println("d2:" + d2.getState());
            System.out.println("sum:" + sum);
            System.out.println();

            if(sum == lastSum) {
                System.out.println("win");
                return;
            }
            if(sum == 7) {
                System.out.println("lose");
                return;
            }
        }

    }

}