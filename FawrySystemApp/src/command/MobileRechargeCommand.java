package command;
import java.util.ArrayList;

import PaymentMethodStrategy.*;
import composite.*;
import discountsDecorator.*;
import mainPackage.*;
import serviceProviders.*;
public class MobileRechargeCommand extends Command {
	IPaymentMethod payment;
	IServiceProviders service;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MobileRechargeCommand()
	{
		
	}
//	public MobileRechargeCommand(User user, Form form) {
//		this.form=form;
//		this.user=user;	
//	}
//	public MobileRechargeCommand(User user, Form form,IServiceProviders service) {
//		this.form=form;
//		this.user=user;
//		this.service=service;	
//	}
	@Override
	public void execute() {
		//form.view();
		//ArrayList<String> values=new ArrayList<String>();
		//values=form.getValues();
		
		//System.out.println(values.get(0));
		if(values.get(0).equals("1"))
		{
			payment=new CreditCardPaymentMethod();
			double c=Double.parseDouble(values.get(1));
			service.setCost(c);
			//System.out.println("SDasda"+service.getCost());
			service=new MobileRechargeDiscount(service);
			System.out.println("ssss"+service.getCost());
			if(user.getTransactionList().size()==0)
			{
				service=new OverallDiscount(service);
			}
				//service=new OverallDiscount(service);
			payment.pay(user, service.getCost());
			System.out.println(user.getCreditCard());
		}
		else if(values.get(0).equals("2"))
		{
			payment=new WalletPaymentMethod();
			double amount=Double.parseDouble(values.get(1));
			
			payment.pay(user, amount);
			System.out.println(user.getWallet());
		}
		else if(values.get(0).equals("3"))
		{
			payment=new CashOnDeliveryMethod();
			double amount=Double.parseDouble(values.get(1));
		}
		else System.out.println("Payment Method not found");
		
		
	}
	
	public IServiceProviders getService() {
		return service;
	}
	public void setService(IServiceProviders service) {
		this.service = service;
	}

	//setters and getters
//	public Form getForm() {
//		return form;
//	}
//	public void setForm(Form form) {
//		this.form = form;
//	}


}
