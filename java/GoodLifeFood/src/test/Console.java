import java.util.Scanner;
import java.util.InputMismatchException;

public class Console {

    private static Scanner in = new Scanner(System.in);

    private Console() {
    }

    public static String getString(String tell) {
        System.out.print(tell);
        String ret = in.next();
        in.nextLine();
        return ret;
    }
    public static int getuInt(String tell) {

        int ret = -1;

        while(ret <= 0) {
            try {
                System.out.print(tell);
                ret = in.nextInt();
                if(ret <= 0) {
                    System.out.println("請輸入正整數");
                }
            } catch(InputMismatchException e) {
                System.out.println("請輸入正整數");
                in.nextLine();
            }
        }

        return ret;
    }
}