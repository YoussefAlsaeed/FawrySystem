package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class LandLineDiscount extends DiscountDecorator{
	static double discountPercentage=0.0;
	public LandLineDiscount(IServiceProviders service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	public static void setDiscountPercentage(double n) {
		discountPercentage=n;
	}
	public static double getDis()
	{
		return discountPercentage;
	}
	@Override
	public boolean pay()
	{
		//System.out.println("d"+discountPercentage);
		double c=service.getCost()*discountPercentage;
		//System.out.println("C"+c);
		setCost(service.getCost()-c);
		System.out.println("Price after applying Landine service discount("+discountPercentage*100+"%) = "+ service.getCost());
		return false;
	}


}
