package ui;

import control.Order;
import product.Product;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.VBox;

public class GoodLifeFood extends Application{

    //protected Order order = new Order();
    protected OrderPane op;
    protected ConsolePane cp = new ConsolePane(this);

    @Override
    public void start(Stage primaryStage){
        op = new OrderPane(this);
        VBox box = new VBox();

        box.getChildren().addAll(op, cp);
        Scene sc = new Scene(box);
        primaryStage.setScene(sc);
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