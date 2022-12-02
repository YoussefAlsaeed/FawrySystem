package discountsDecorator;

import serviceProviders.*;

public abstract class DiscountDecorator implements IService {

	IService service;
	protected double discountPercentage=0.1;
	@Override
	public abstract double getCost();
	@Override
	public abstract void setCost(double n) ;
	public abstract void setDiscountPercentage(double n) ;
	public abstract double calculateCost();

}
