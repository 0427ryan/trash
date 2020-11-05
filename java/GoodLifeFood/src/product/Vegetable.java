package product;

import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL32;

public class Vegetable extends Product{
	
    protected BigDecimal quantity;
    protected static BigDecimal perWeight = new BigDecimal("0.5");

    static{
        priceInSingle = new BigDecimal("222");
    }
	
	public Vegetable(){
        quantity = new BigDecimal("0");
	}

    @Override
    public void setQuantity(Number q){
        if()
    }

    public Vegetable(String quantity){
        this.quantity = new BigDecimal(quantity).divide(perWeight, DECIMAL32);
    }

    public Vegetable(int quantity){
        this.quantity = new BigDecimal(quantity);
    }

}