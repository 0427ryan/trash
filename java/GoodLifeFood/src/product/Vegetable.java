package product;

public class Vegetable {
	
    int price;
    int quantity;
	
	public Vegetable(){
		
	}
	public String getName(){
        return this.getClass().getName();
    }
}