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
		System.out.println("-----------------------");
		applyDiscounts();
		System.out.println("-----------------------");
		double amount=service.getCost();
		
		if(values.get(0).toLowerCase().contains("credit"))
		{
			this.payment=new CreditCardPaymentMethod();
			if(!payment.pay(user,amount)) return null;
			System.out.println("Your credit card balance=" +user.getCreditCard());
		}
		else if(values.get(0).toLowerCase().contains("wallet"))
		{
			payment=new WalletPaymentMethod();
			if(!payment.pay(user, amount)) return null;
			System.out.println("Your wallet balance="+user.getWallet());
		}
		else if(values.get(0).toLowerCase().contains("cash"))
		{
			payment=new CashOnDeliveryMethod();
		}
		else {
			System.out.println("Payment Method not found");
			return null;
		}
		System.out.println(payment);
		PaymentTransaction t=new PaymentTransaction(sName, amount, payment);
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
