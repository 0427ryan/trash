package app;

import product.*;

public class ProductDB {

    private static StringBuilder pre = new StringBuilder("product.");

    private ProductDB(){
    }

    public static Product getProduct(String name, String quantity, String quantifier){
        Product p;

        if(name.contains(".")){
            p = new DefaultProduct();
        }else{
            try{
                p = (Product)Class.forName("product."+name)
                                  .getDeclaredConstructor()
                                  .newInstance();
            }catch(Exception e){
                p = new DefaultProduct();
            }
        }
        
        p.setQuantity(quantity);
        p.changeQuantifier(quantifier);
        return p;
    }

}   