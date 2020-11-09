package product;

import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL32;

public class Vegetable extends ProductCountableByWeight{


	public Vegetable(){
        perWeight = new BigDecimal("0.5");
        priceInSingle = new BigDecimal("222");
	}
}