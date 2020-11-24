package gui;

import app.ProductDB;
import product.Product;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ConsolePane extends HBox{

    protected GoodLifeFood base;

    protected TextField input = new TextField();
    protected Button ok = new Button("ok");

    public ConsolePane(GoodLifeFood base){
        this.base = base;

        ok.setOnMouseClicked( e -> base.add(ProductDB.getProduct( input.getText(), "0", "")) );
        setSpacing(10.0);
        this.getChildren().addAll(input, ok);
    }
}