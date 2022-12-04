package serviceProviders;

import java.util.ArrayList;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class Donation implements IService,IServiceProviders{

	IPaymentMethod paymentMethod;
	Form form;
	DonationsCommand c;
	double cost;
	public Donation(Form form,DonationsCommand c)
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
		pay(user,values);
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
