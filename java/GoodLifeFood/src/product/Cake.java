package product;

import java.math.BigDecimal;

public class Cake extends Product{
	
    protected String message;
    protected int quantity;

    static{
        priceInSingle = new BigDecimal("100");
    }

    @Override
    public void setQuantity(Number q){
        quantity = q.intValue();
    }

    protected void calculateCost(){
        cost = priceInSingle.multiply(new BigDecimal(quantity));
    }

	public Cake(){
        this.quantity = 0;
        this.message  = "";
	}

    public Cake(int quantity){
        this.quantity = quantity;
        this.message  = "";
    }

	public Cake(int quantity, String message){
        this.quantity = quantity;
        this.message  = message;
    }

    @Override
    public void print(){
        calculateCost();
        System.out.println("Name         :" + getName());
        System.out.println("Message      :" + message);
        System.out.println("Single price :" + priceInSingle);
        System.out.println("Quantuty     :" + quantity);
        System.out.println("Total cost   :" + cost);
    }
}