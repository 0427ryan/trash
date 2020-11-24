package gui;

import product.Product;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;

public class GoodLifeFood extends Application{

    protected OrderPane op;
    protected ConsolePane cp = new ConsolePane(this);

    @Override
    public void start(Stage primaryStage){
        op = new OrderPane(this);
        BorderPane mainPane = new BorderPane();

        mainPane.setBottom(cp);
        mainPane.setCenter(op);

        Scene sc = new Scene(mainPane);

        primaryStage.setScene(sc);

        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(400);

        primaryStage.setHeight(300);
        primaryStage.setWidth(400);

        primaryStage.show();
    }

    public void add(Product p){
        op.add(p);
    }

    public static void main(String[] args) {
        launch(args);
    }
}