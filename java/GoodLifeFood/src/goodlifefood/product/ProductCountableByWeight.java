package product;

import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL32;

public abstract class ProductCountableByWeight extends Product{
    
    protected BigDecimal perWeight = new BigDecimal(1);
    
    public ProductCountableByWeight(){
        availableQuantifier.add("kg");
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