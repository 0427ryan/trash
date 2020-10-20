import java.util.LinkedList;

public class Order {
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
			}
		}
	}
	public Object getProductList(){
		
	}
}