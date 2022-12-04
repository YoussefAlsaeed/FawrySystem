package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public class MobileRechargeDiscount extends DiscountDecorator{

	IService service;
	MobileRechargeDiscount(IService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return calculateCost();
	}
	@Override
	public void setCost(double n) {
		this.discountPercentage=n;
		
	}
	@Override
	public double calculateCost() {
		double c=service.getCost()*discountPercentage;
		service.setCost(service.getCost()-c);
		return service.getCost();
	}
	@Override
	public void setDiscountPercentage(double n) {
		this.discountPercentage=n;
	}
	@Override
	public boolean pay(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}


