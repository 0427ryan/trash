package product;

import java.math.BigDecimal;

public class Cake extends Product{
	
    protected String message;

    static{
        priceInSingle = new BigDecimal("100");
    }

	public Cake(){
        this(0);
	}

    public Cake(int quantity){
        this(quantity, "");
    }

	public Cake(int quantity, String message){
        this.quantity = new BigDecimal(quantity);
        this.message  = message;
    }

    @Override
    public void print(){
        calculateCost();
        System.out.println("Name         :" + getName());
        System.out.println("Message      :" + message);
        System.out.println("Single price :" + priceInSingle);
        System.out.println("Quantuty     :" + quantity + ' ' + quantifier);
        System.out.println("Total cost   :" + cost);
    }
}