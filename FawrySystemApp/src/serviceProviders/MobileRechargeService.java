package serviceProviders;

import java.util.ArrayList;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class MobileRechargeService implements IService,IServiceProviders{

	IPaymentMethod paymentMethod;
	private double cost;
	private Form form;
	private MobileRechargeCommand c;
	public MobileRechargeService(Form form,MobileRechargeCommand c)
	{
		this.form=form;
		this.c=c;
	}
	public void pay(User user,ArrayList<String> values)
	{
		c.setValues(values);
		c.setService(this);
		c.setUser(user);
		c.execute();
	}
	public boolean fillForm(User user)
	{
		form.view();
		ArrayList<String> values=new ArrayList<String>();
		values=form.getValues();
		System.out.println(values);
		pay(user,values);
		return false;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
