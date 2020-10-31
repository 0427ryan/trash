
public class Product {

    private String name = "unknown";
    private int price = 0;
    private int quantity = 0;
    private int cost = 0;

    public Product(){};

    public Product(String name, int price){
        this(name, price, 0);
    }
    public Product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean setQuantity(int q){
        if(q > 0){
            quantity = q;
            return true;
        }
        return false;
    }

    public void calculateCost(){
        cost = price * quantity;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public void print(){
        calculateCost();
        System.out.println("Name         :" + name);
        System.out.println("Single price :" + price);
        System.out.println("Quantuty     :" + quantity);
        System.out.println("Total cost   :" + cost);
    }
}