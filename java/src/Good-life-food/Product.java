
public abstract class Product {

    protected Product() {
    }

    protected static abstract void setPriceInSingle(int price);

    public abstract int getPrice();

    public String getName(){
        return "Product";
    }
}