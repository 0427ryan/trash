package cardgames;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Console {
    /*
        this class is used to get input, the Scanner inside can be change.
    */
    private Scanner in = new Scanner(System.in);
    private CardGameView err = new ConsoleView();

    public Console(){
    }

    public Console(Scanner in, CardGameView err){
        this.in = in;
        this.err = err;
    }

    public Scanner getScanner(){
        return in;
    }

    public void setScanner(Scanner in){
        this.in = in;
    }

    public CardGameView getErr(){
        return err;
    }

    public void setErr(CardGameView err){
        this.err = err;
    }

    public int nextInt(){
        int ret;
        while(true){
            try{
                ret = in.nextInt();
                in.nextLine();
                return ret;
            }catch(InputMismatchException e){
                err.println("Please enter interger.");
                in.nextLine();
            }
        }
    }

    public int nextuInt(){
        int ret = -1;
        while(true){
            try{
                ret = in.nextInt();
                in.nextLine();
                if(ret >= 0){
                    return ret;
                }
                err.println("Please enter non negative integer.");
            }catch(Exception e){
                err.println("Please enter non negative integer.");
                in.nextLine();
            }
        }
    }

    public String nextLine(){
        String ret;
        ret = in.nextLine();
        return ret;
    }

    public String nextString(){
        String ret;
        ret = in.nextLine();
        return ret;
    }

    public String nextString(String... regexs){
        String ret;
        while(true){
            ret = in.nextLine();
            for(String i : regexs){
                if(ret.matches(i)){
                    return ret;
                }
            }
            err.println("Please enter correctly.");
        }
    }
}