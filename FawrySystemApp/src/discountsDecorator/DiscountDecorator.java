package discountsDecorator;

import mainPackage.User;
import serviceProviders.*;

public abstract class DiscountDecorator implements IServiceProviders {

	DiscountDecorator(IServiceProviders service) {
		this.service=service;
		pay();
		//getCost();
		// TODO Auto-generated constructor stub
	}
	IServiceProviders service;
	 double cost;
	//protected static double discountPercentage;
	public abstract boolean pay();
	
	
	@Override
	public void setCost(double n) {
		this.cost=n;
		
	}
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost;
	}


}
