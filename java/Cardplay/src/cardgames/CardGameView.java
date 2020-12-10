package cardgames;

import java.io.PrintStream;

public class CardGameView{

    PrintStream out = System.out;
    
    public CardGameView(){

    }

    public CardGameView(PrintStream out){
        this.out = out;
    }

    public void print(Object s){
        out.print(s);
    }
    
    public void println(Object s){
        out.println(s);
    }
    public void println(){
        System.out.println();
    }
}