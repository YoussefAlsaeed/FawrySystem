package discountsDecorator;

import serviceProviders.*;

public class LandLineDiscount extends DiscountDecorator{

	IService service;
	
	LandLineDiscount(IService service) {
	
		this.service=service;
		this.service=service;
		//getCost();
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getCost() {
		double c=service.getCost()*0.1;
		service.setCost(service.getCost()-c);
		return service.getCost();
	}
	@Override
	public void setCost(double n) {
		//this.discountPercentage=n;
		
	}
	@Override
	public double calculateCost() {
//		double c=service.getCost()*0.1;
//		service.setCost(service.getCost()-c);
		return service.getCost();
	}
	@Override
	public void setDiscountPercentage(double n) {
		this.discountPercentage=n;
	}


}
