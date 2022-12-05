package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class OverallDiscount extends DiscountDecorator{
	static double discountPercentage=0.1;
	public OverallDiscount(IServiceProviders service) {
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
		System.out.println("Discount ="+ service.getCost());
		return false;
	}
	
}
