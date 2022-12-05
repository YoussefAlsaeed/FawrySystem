package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class MobileRechargeDiscount extends DiscountDecorator{
	static double discountPercentage=0.1;
	public MobileRechargeDiscount(IServiceProviders service) {
		
		super(service);
		//discountPercentage=0.1;
		// TODO Auto-generated constructor stub
	}
	//public MobileRechargeDiscount() {}
	public static void setDiscountPercentage(double n) {
		//System.out.println("rrrrrr");
		//discountPercentage=0.1;
		discountPercentage=n;
		//System.out.println("ggyg"+discountPercentage);
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


