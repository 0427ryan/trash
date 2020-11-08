package control;

import product.Product;

public class ProductDB {

    private ProductDB(){
    }

    @SuppressWarnings("deprecation")
    public static Product getProduct(String name){
        try{
            return (Product)Class.forName("product." + name).newInstance();
        }catch(Exception e){
            return null;
        }
    }
}   