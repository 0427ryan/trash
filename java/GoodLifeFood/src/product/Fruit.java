package product;

public abstract class Fruit extends Product{
	
	int price;
	int quantity;

	protected Fruit(){
	}

	public abstract int getPrice();

    public String getName(){
        return "Fruit";
    }
}