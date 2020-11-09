package product;

public class DefaultProduct extends Product{
    public DefaultProduct(){
    }

    @Override
    public String getName(){
        return "unknown product";
    }

}