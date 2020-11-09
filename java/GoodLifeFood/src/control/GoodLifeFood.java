package control;

public class GoodLifeFood {

    public GoodLifeFood() {
        Order order = new Order();
        System.out.println("Welcome");
        do {
            System.out.println();
            order.addProduct(
                ProductDB.getProduct(//"Vegetable","123","kg"
                    Console.getString("Enter product name :"),
                    Console.getBigDecimal("Enter product quantity :").toString(),
                    Console.getString("Enter product quantifier :")
                )
            );
            System.out.println();
        }while(
            Console.getString("Next product ? (y/n) ").compareToIgnoreCase("y") == 0
        );
        for(product.Product p : order){
            System.out.println();
            p.print();
        }
        System.out.println("Total cost :" + order.getCost());
    }

}