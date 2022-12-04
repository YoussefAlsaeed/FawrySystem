package serviceProviders;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class InternetPayment implements IService{

	IPaymentMethod paymentMethod;
	Form form;
	Command c;
	public InternetPayment(Form form,Command c)
	{
		this.form=form;
		this.c=c;
		form.view();
	}
	public boolean pay(User user)
	{
		c=new SubmitCommand(user,form);
		c.execute();
		return false;
	}
	
}
