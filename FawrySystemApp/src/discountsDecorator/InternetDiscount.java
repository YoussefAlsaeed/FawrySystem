package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class InternetDiscount extends DiscountDecorator{
	static double discountPercentage;
	public InternetDiscount(IServiceProviders service) {
		super(service);
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