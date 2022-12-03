package transaction;

import serviceProviders.*;

public class PaymentTransaction implements ITransaction
{
	private IService service;
	private String TransactionId;
	private static int counter=0;
	private double amount;
	public  PaymentTransaction(IService service,double amount) 
	{
		counter++;
		TransactionId="1"+Integer.toString(counter);
		this.service = service;
		this.amount=amount;
	}

	public String toString()
	{
		return "Transaction ID is "+ TransactionId +("\n")+ "amount is "+ amount +"\n" +"provider is "+ service.getClass().getSimpleName() ;
		
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
