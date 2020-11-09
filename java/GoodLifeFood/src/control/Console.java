package control;

import java.util.Scanner;
import java.math.BigDecimal;

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
    public static BigDecimal getBigDecimal(String tell) {

        BigDecimal ret = new BigDecimal(0);

        do{
            try{
                System.out.print(tell);
                ret = new BigDecimal(in.next());
                in.nextLine();
                if(ret.doubleValue() <= 0) {
                    System.out.println("請輸入正整數");
                }
            }catch(Exception e){
                System.out.println("請輸入正整數");
            }
            
        }while(ret.doubleValue() <= 0);

        return ret;
    }
}