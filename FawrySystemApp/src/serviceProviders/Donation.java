package serviceProviders;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class Donation implements IService,IServiceProviders{

	IPaymentMethod paymentMethod;
	Form form;
	Command c;
	double cost;
	public Donation(Form form,Command c)
	{
		this.form=form;
		this.c=c;
	}
	public boolean pay(User user)
	{
		c=new DonationsCommand(user,form,this);
		c.execute();
		return false;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		System.out.println("service");
		this.cost = cost;
	}
	
}
