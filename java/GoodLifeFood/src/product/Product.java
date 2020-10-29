package product;

public abstract class Product {

    protected Product() {
    }

    protected static void setPriceInSingle(int price){};

    public abstract int getPrice();

    public String getName(){
        return this.getClass().getName();
    }
}