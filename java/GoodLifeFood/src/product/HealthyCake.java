package product;

import java.math.BigDecimal;

public class HealthyCake extends Product{

    protected String message = "";

    public HealthyCake(){
        this(0);
    }

    public HealthyCake(int quantity){
        this(quantity, "");
    }

    public HealthyCake(int quantity, String message){
        this.quantity = new BigDecimal(quantity);
        checkQuantity();
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