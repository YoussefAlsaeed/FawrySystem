package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;
/*
 * Concrete Decorator
 */
public class DonationsDiscount extends DiscountDecorator{
	static double discountPercentage=0.0;
	public DonationsDiscount(IServiceProviders service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	public static void setDiscountPercentage(double n) {
		discountPercentage=n;
	}
	public static double getDis()//get discount percenatge 
	{
		return discountPercentage;
	}
	@Override
	public boolean pay()
	{
		double c=service.getCost()*discountPercentage;//calculate amount after applying discount
		setCost(service.getCost()-c);
		System.out.println("Price after applying donation service discount("+discountPercentage*100+"%) ="+ service.getCost());
		return false;
	}	

}
