
public abstract class Fruit extends Product{
	
	int price;
	int quantity;

	protected Fruit(){
	}

	public abstract int getPrice();

    @Override
    public String getName(){
        return "Fruit";
    }
}