package discountsDecorator;

import serviceProviders.*;

public class MobileRechargeDiscount extends DiscountDecorator{

	IService service;
	MobileRechargeDiscount(IService service) {
		this.service=service;
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
	
}


