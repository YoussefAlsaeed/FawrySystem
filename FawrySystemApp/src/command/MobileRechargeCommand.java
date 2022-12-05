package command;
import java.util.ArrayList;

import PaymentMethodStrategy.*;
import composite.*;
import discountsDecorator.*;
import mainPackage.*;
import serviceProviders.*;
import transaction.ITransaction;
import transaction.PaymentTransaction;
public class MobileRechargeCommand extends Command {
	IPaymentMethod payment;
	IServiceProviders service;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		service=new MobileRechargeDiscount(service);
		
		if(user.getTransactionList().size()==0)
		{
			service=new OverallDiscount(service);
		}
		
		
	}
	public IServiceProviders getService() {
		return service;
	}
	public void setService(IServiceProviders service) {
		this.service = service;
	}


}
