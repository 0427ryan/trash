package control;
import java.util.LinkedList;

public class Order {

	int sumPrice = 0;
	LinkedList<Product> productList = new LinkedList<>();

	public Order(){	
	}
	public Order(Product... products){
		addProduct(products);
	}
	public void addProduct(Product... products){
		for(Product p : products){
			if(product != null){
				productList.add(product);
				sumPrice += product.getPrice();
			}
		}
	}
	public Object[] getProductList(){
		return productList.toArray();
	}
}