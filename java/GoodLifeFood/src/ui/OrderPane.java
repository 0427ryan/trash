package ui;

import javafx.scene.layout.VBox;
import control.Order;
import product.Product;
import java.util.LinkedList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;

public class OrderPane extends VBox{
    protected GoodLifeFood base;
    public OrderPane(GoodLifeFood base){
        this.base = base;
    }

    public void delete(Pane pane, Product product){
        getChildren().removeAll(pane);
        //order.deleteProduct(product);
    }

    public void add(Product product){
        getChildren().addAll(new ProductPane(this, product));
       // order.deleteProduct(product);
    }
    
}
