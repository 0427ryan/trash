package gui;

import product.Product;

import java.math.BigDecimal;
import static java.math.BigDecimal.ONE;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ProductPane extends HBox {

    Product product;
    OrderPane orderPane;

    Text name;
    Button incBt = new Button("+");
    Button decBt = new Button("-");
    Button delBt = new Button("x");
    Button ok = new Button("ok");
    TextField input = new TextField();

    public ProductPane(OrderPane orderPane, Product product) {
        this.product = product;
        this.orderPane = orderPane;
        input.setText("0");
        name = new Text(product.getName());

        incBt.setOnMouseClicked( e -> input.setText(
            new BigDecimal(input.getText()).add(ONE).toString()
        ));
        decBt.setOnMouseClicked( e -> input.setText(
            new BigDecimal(input.getText()).subtract(ONE).toString()
        ));
        delBt.setOnMouseClicked( e -> orderPane.delete(this, product) );
        
        ok.setOnMouseClicked( e -> product.setQuantity(input.getText()) );

        setSpacing(10);
        setMinWidth(600);
        this.getChildren().addAll(name, decBt, input, incBt, ok, delBt);
    }
}