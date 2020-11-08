package product;

import java.math.BigDecimal;

//if extends this,need to realize
// public void print();

public abstract class Product{

    protected static BigDecimal priceInSingle;
    protected BigDecimal quantity;
    protected BigDecimal cost;
    protected String quantifier = "個";

    public void changeQuantifier(String q){
        quantifier = q;
    }

    public static BigDecimal getPriceInSingle(){
        return priceInSingle;
    }

    protected void calculateCost(){
        cost = quantity.multiply(priceInSingle);
    }

    public BigDecimal getCost(){
        calculateCost();
        return cost;
    }

    @Override
    public boolean equals(Object o){
        if( o instanceof Product && ((Product)o).getName().equals(this.getName()) ){
                return true;
        }
        return false;
    }

    public void setQuantity(String q){
        this.quantity = new BigDecimal(q);
    }

    public void setQuantity(int q){
        this.quantity = new BigDecimal(q);
    }

    public void addQuantity(String q){
        this.quantity = new BigDecimal(q).add(this.quantity);
    }

    public void addQuantity(int q){
        this.quantity = new BigDecimal(q).add(this.quantity);
    }

    public void print(){
        calculateCost();
        System.out.println("Name         :" + getName());
        System.out.println("Single price :" + priceInSingle);
        System.out.println("Quantuty     :" + quantity + ' ' + quantifier);
        System.out.println("Total cost   :" + cost);
    }

    public String getName(){
        return this.getClass().getName();
    }
}