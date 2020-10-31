
public class GoodLifeFood {

    public GoodLifeFood() {
        Product p;
        System.out.println("Welcom");
        do {
            System.out.println();
            p = ProductDB.getProduct(
                Console.getString("Enter product name :")
            );
            p.setQuantity(
                Console.getuInt("Enter product quantity :")
            );
            System.out.println();
            p.print();
            System.out.println();
        }while(
            Console.getString("Next product ? (y/n) ").compareToIgnoreCase("y") == 0
        );
    }

}