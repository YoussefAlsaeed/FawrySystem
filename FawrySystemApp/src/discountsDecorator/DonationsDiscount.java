package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class DonationsDiscount extends DiscountDecorator{
	static double discountPercentage=0.0;
	public DonationsDiscount(IServiceProviders service) {
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
		double c=service.getCost()*discountPercentage;
		setCost(service.getCost()-c);
		System.out.println("Price after applying donation service discount("+discountPercentage*100+")="+ service.getCost());
		return false;
	}	

}
