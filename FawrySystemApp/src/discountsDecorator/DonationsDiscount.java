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
		double cost=service.getCost()-c;
		setCost(cost);
		System.out.println("Price after applying mobile recharge service discount("+discountPercentage*100+"%)="+ cost);
		return false;
	}	

}
