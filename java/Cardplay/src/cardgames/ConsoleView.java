package cardgames;

import java.io.PrintStream;

public class ConsoleView implements CardGameView {

    PrintStream out = System.out;

    public ConsoleView() {

    }

    public ConsoleView(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(Object s) {
        out.print(s);
    }
    @Override
    public void println(Object s) {
        out.println(s);
    }

    @Override
    public void println() {
        System.out.println();
    }


}