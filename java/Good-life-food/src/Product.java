
public abstract class Product {

	protected static priceInSingle;

	protected Product(){
	}
	protected static void setPrice(int _price){
		price = _price;
		return;
	}
	public abstract int getPrice();
	public abstract String toString();
}