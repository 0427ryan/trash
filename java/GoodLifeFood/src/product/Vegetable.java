package product;

import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL32;

public class Vegetable extends Product{

    protected static BigDecimal perWeight = new BigDecimal("0.5");

    static{
        priceInSingle = new BigDecimal("222");
    }

	public static BigDecimal getPerWeight(){
        return perWeight;
    }

	public Vegetable(){
        this(0);
	}
    public Vegetable(String quantity){
        this.setQuantity(quantity);
        quantifier = "kg";
    }

    public Vegetable(int quantity){
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