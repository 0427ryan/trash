package product;

import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL32;

public class Fruit extends Product{

    protected static BigDecimal perWeight = new BigDecimal("1.2");

    static{
        priceInSingle = new BigDecimal("333");
    }

    public static BigDecimal getPerWeight(){
        return perWeight;
    }

    public Fruit(){
        this(0);
    }

    public Fruit(String quantity){
        this.setQuantity(quantity);
        quantifier = "kg";
    }

    public Fruit(int quantity){
        this.setQuantity(quantity);
    }

    @Override
    protected void calculateCost(){
        super.calculateCost();
        if(quantifier.equals("kg")){
            cost = cost.divide(perWeight, DECIMAL32);
        }
    }

    @Override
    public void print(){
        calculateCost();
        System.out.println("Name         :" + getName());
        System.out.println("Single price :" + priceInSingle);
        System.out.println("Perweight    :" + perWeight);
        System.out.println("Quantuty     :" + quantity + ' ' + quantifier);
        System.out.println("Total cost   :" + cost);
    }
    
}