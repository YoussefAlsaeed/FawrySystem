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
		
		double c=service.getCost()*discountPercentage;//calculate amount after applying discount
		setCost(service.getCost()-c);
		System.out.println("Price after applying overall discount("+discountPercentage*100+"%)="+ service.getCost());
		return false;
	}
	
}
