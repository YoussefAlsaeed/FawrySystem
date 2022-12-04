package transaction;

import PaymentMethodStrategy.*;
import serviceProviders.*;

public class PaymentTransaction implements ITransaction
{
	//private IServiceProviders service;
	private String serviceName;
	private String TransactionId;
	private static int counter=0;
	private double amount;
	private IPaymentMethod paymentMethod;

	public PaymentTransaction(String sName, double amount, IPaymentMethod paymentMethod) {
		counter++;
		TransactionId="1"+Integer.toString(counter);
		this.serviceName = sName;
		this.amount=amount;
		this.paymentMethod=paymentMethod;
	}

	public String toString()
	{
		return "\n<Transaction ID is "+ TransactionId +(">\n")+ "<Amount payed by user "+ amount +">\n" +"<Provider is "+ serviceName+">\n"+"<"+paymentMethod+">" ;
		
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return TransactionId;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	
}
