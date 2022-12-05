package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class MobileRechargeDiscount extends DiscountDecorator{
	static double discountPercentage=0.1;
	public MobileRechargeDiscount(IServiceProviders service) {
		
		super(service);
	}
	//public MobileRechargeDiscount() {}
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
		//calculate amount after applying discount
		double c=service.getCost()*discountPercentage;
		setCost(service.getCost()-c);
		System.out.println("Price after applying mobile recharge service discount("+discountPercentage*100+"%)="+ service.getCost());
		return false;
	}
}


