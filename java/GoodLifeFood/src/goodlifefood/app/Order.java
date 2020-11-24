package app;

import java.util.LinkedList;
import java.math.BigDecimal;
import product.Product;
import java.util.Iterator;

public class Order implements Iterable<Product>{

    BigDecimal cost = new BigDecimal(0);
    LinkedList<Product> productList = new LinkedList<>();

    public Order() {
    }

    @Override
    public Iterator<Product> iterator(){
        return productList.iterator();
    }

    public Order(Product... products) {
        addProduct(products);
    }

    public void addProduct(Product... products) {
        for(Product p : products){
            if(p != null){   
                productList.add(p);
            }
        }
        calculateCost();
    }

    public void deleteProduct(Product... products) {
        for(Product p : products) {
            productList.remove(p);
        }
        calculateCost();
    }
    
    public Product getProduct(int index){
        return productList.get(index);
    }

    public LinkedList<Product> getList(){
        return productList;
    }

    public void calculateCost(){
        cost = new BigDecimal(0);
        for(Product p : productList){
            cost = cost.add(p.getCost());
        }
    }
    public BigDecimal getCost(){
        return cost;
    }
}