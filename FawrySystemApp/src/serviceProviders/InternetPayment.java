package serviceProviders;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class InternetPayment implements IService,IServiceProviders{

	IPaymentMethod paymentMethod;
	Form form;
	Command c;
	double cost;
	public InternetPayment(Form form,Command c)
	{
		this.form=form;
		this.c=c;
		form.view();
	}
	public boolean pay(User user)
	{
		c=new MobileRechargeCommand(user,form);
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
