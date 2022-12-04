package serviceProviders;

import PaymentMethodStrategy.*;
import command.*;
import composite.*;
import mainPackage.*;

public abstract class MobileRechargeService implements IService{

	IPaymentMethod paymentMethod;
	Form form;
	Command c;
	public MobileRechargeService(Form form,Command c)
	{
		this.form=form;
		this.c=c;
		
		//form.view();
	}
	public boolean pay(User user)
	{
		
		c=new SubmitCommand(user);
		c.execute();
		return false;
	}
	
}
