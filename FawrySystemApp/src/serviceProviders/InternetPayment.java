package serviceProviders;

import java.util.ArrayList;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;
import transaction.ITransaction;

public abstract class InternetPayment implements IService,IServiceProviders{

	IPaymentMethod paymentMethod;
	Form form;
	InternetCommand c;
	double cost;
	public InternetPayment(Form form,InternetCommand c)
	{
		this.form=form;
		this.c=c;
	}
	public ITransaction pay(User user)
	{
		form.view();
		ArrayList<String> values=new ArrayList<String>();
		values=form.getValues();
		System.out.println(values);
		c.setValues(values);
		c.setService(this);
		c.setUser(user);
		return c.execute();
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		
		this.cost = cost;
	}
	@Override
	public String toString()
	{
		return "Internet Payment Service";
	}
	
}
