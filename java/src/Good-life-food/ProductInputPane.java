import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ProductInputPane extends FlowPane {

    Product product;

    Text name;
    Button incBt = new Button("+");
    Button decBt = new Button("-");
    TextField input = new TextField();

    public ProductInputPane(Product product) {
        this.product = product;
        this.name = new Text(product.getName());
        this.getChildren().addAll(name, incBt, input, decBt);
    }

}