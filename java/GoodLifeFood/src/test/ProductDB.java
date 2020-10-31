
public class ProductDB {

    private ProductDB(){
    }

    public static Product getProduct(String name){
        Product p;

        switch(name){
            case "vegetable":
                p = new Product("vegetable", 100);
                break;
            case "healthy cake":
                p = new Product("healthy cake", 200);
                break;
            case "fruit":
                p = new Product("fruit", 50);
                break;
            default:
                p = new Product();
        }
        return p;
    }
}