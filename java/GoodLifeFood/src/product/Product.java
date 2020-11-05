package product;

import java.math.BigDecimal;

//if extends this,need to realize
// public void setQuantity(Number q);
// public void print();

public abstract class Product {

    protected static BigDecimal priceInSingle;
    protected BigDecimal cost;

    public static BigDecimal getPriceInSingle(){
        return priceInSingle;
    }

    abstract protected void calculateCost();

    public BigDecimal getCost(){
        return cost;
    }

    //if successful, return true, else, return false.
    abstract public void setQuantity(Number q);

    // this should contain name,
    // price in single, quantity, and cost.
    abstract public void print();

    public String getName(){
        return this.getClass().getName();
    }
}