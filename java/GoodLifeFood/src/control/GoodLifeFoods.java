package control;

public class GoodLifeFoods {
	private static DeliverSystem deliverSystem = new DeliverSystem();
	private static OrderSystem orderSystem = new OrderSystem(deliverSystem);

	private GoodLifeFoods(){
	}
	


}