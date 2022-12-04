package discountsDecorator;

import serviceProviders.*;

public abstract class DiscountDecorator implements IService {

	DiscountDecorator(IService service) {
		this.service=service;
		//getCost();
		// TODO Auto-generated constructor stub
	}
	IService service;
	protected double discountPercentage=0.0;
	public abstract void setDiscountPercentage(double n) ;
	public abstract double calculateCost();

}
