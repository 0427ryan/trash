package product;

import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL32;

public class Fruit extends ProductCountableByWeight{

    public Fruit(){
        perWeight = new BigDecimal("1.2");
        priceInSingle = new BigDecimal("333");
    }
}