package product;

import java.math.BigDecimal;
import java.util.LinkedList;

public abstract class Product{

    protected BigDecimal priceInSingle = new BigDecimal(0);
    protected BigDecimal quantity = new BigDecimal(0);;
    protected BigDecimal cost = new BigDecimal(0);
    protected String quantifier = "個";
    protected LinkedList<String> availableQuantifier = new LinkedList<>();

    {
        availableQuantifier.add("個");
    }

    public void changeQuantifier(String q){
        if( availableQuantifier.contains(q) ){
            quantifier = q;
        }
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
        checkQuantity();
    }

    public void setQuantity(int q){
        this.quantity = new BigDecimal(q);
        checkQuantity();
    }

    public void addQuantity(String q){
        this.quantity = new BigDecimal(q).add(this.quantity);
        checkQuantity();
    }

    public void addQuantity(int q){
        this.quantity = new BigDecimal(q).add(this.quantity);
        checkQuantity();
    }

    public void print(){
        calculateCost();
        System.out.println("Name         :" + getName());
        System.out.println("Single price :" + priceInSingle);
        System.out.println("Quantuty     :" + quantity + ' ' + quantifier);
        System.out.println("Total cost   :" + cost);
    }

    protected void checkQuantity(){
        if(this.quantity.compareTo(BigDecimal.ZERO) == -1){
            this.quantity = new BigDecimal(0);
        }
    }

    public String getName(){
        return this.getClass().getName().substring(8);
    }
}