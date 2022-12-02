package discountsDecorator;

import serviceProviders.*;

public class InternetDiscount extends DiscountDecorator{

	IService service;
	double cost;
	InternetDiscount(IService service) {
		this.service=service;
		//double c=service.getCost()*0.1;
		//cost=service.getCost()-c;
		//getCost();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCost() {
		double c=service.getCost()*discountPercentage;
		cost= service.getCost()-c;
		return cost;
	}

	
	@Override
	public void setCost(double n) {
		this.discountPercentage=n;
		
	}
	@Override
	public double calculateCost() {
		//double c=service.getCost()*0.1;
		//service.setCost(service.getCost()-c);
		return service.getCost();
	}
	@Override
	public void setDiscountPercentage(double n) {
		this.discountPercentage=n;
	}

}