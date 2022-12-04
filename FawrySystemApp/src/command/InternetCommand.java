package command;

import java.util.ArrayList;

import PaymentMethodStrategy.*;
import composite.Form;
import discountsDecorator.*;
import mainPackage.User;
import serviceProviders.*;
import transaction.ITransaction;
import transaction.PaymentTransaction;

public class InternetCommand extends Command{

	//Form form;
	IPaymentMethod payment;
	IServiceProviders service;
//	public InternetCommand(User user, Form form) {
//		this.form=form;
//		this.user=user;	
//	}
//	public InternetCommand(User user, Form form,IServiceProviders service) {
//		this.form=form;
//		this.user=user;
//		this.service=service;	
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IServiceProviders getService() {
		return service;
	}
	public void setService(IServiceProviders service) {
		this.service = service;
	}
	@Override
	public ITransaction execute() {
		double c=Double.parseDouble(values.get(1));
		service.setCost(c);	
		String sName=service.toString();
		applyDiscounts();
		double amount=service.getCost();
		
		if(values.get(0).equals("1"))
		{
			this.payment=new CreditCardPaymentMethod();
			payment.pay(user,amount);
			System.out.println(user.getCreditCard());
		}
		else if(values.get(0).equals("2"))
		{
			payment=new WalletPaymentMethod();
			payment.pay(user, amount);
			System.out.println(user.getWallet());
		}
		else if(values.get(0).equals("3"))
		{
			payment=new CashOnDeliveryMethod();
		}
		else System.out.println("Payment Method not found");
		System.out.println(payment);
		PaymentTransaction t=new PaymentTransaction(sName, amount, payment);
		System.out.println(t);
		user.addTransaction(t);
		return t;
		
		
	}
	
	
	public void applyDiscounts()
	{
		service=new InternetDiscount(service);
		
		if(user.getTransactionList().size()==0)
		{
			service=new OverallDiscount(service);
		}
		
		
	}
	
	//setters and getters
	
//	public Form getForm() {
//		return form;
//	}
//	public void setForm(Form form) {
//		this.form = form;
//	}
	public IPaymentMethod getPayment() {
		return payment;
	}
	public void setPayment(IPaymentMethod payment) {
		this.payment = payment;
	}


}
