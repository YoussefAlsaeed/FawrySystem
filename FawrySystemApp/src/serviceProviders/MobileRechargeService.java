package serviceProviders;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class MobileRechargeService implements IService,IServiceProviders{

	IPaymentMethod paymentMethod;
	private double cost;
	private Form form;
	private Command c;
	public MobileRechargeService(Form form,Command c)
	{
		this.form=form;
		this.c=c;
		
		//form.view();
	}
	public boolean pay(User user)
	{
		
		c=new MobileRechargeCommand(user, form,this);
		c.execute();
		return false;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
