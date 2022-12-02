package transaction;

import serviceProviders.*;

public class PaymentTransaction implements ITransaction
{
	private IService service;
	private String TransactionId;
	private int counter;
	private int amount;
	public  PaymentTransaction(IService service,int amount) 
	{
		counter++;
		TransactionId="1"+Integer.toString(counter);
		this.service = service;
	}
		
	
	public String toString()
	{
		return "Transaction ID is "+ TransactionId +("\n")+ "amount is "+ amount +"\n" +"provider is "+ service.getClass().getSimpleName() ;
		
	}
	
}
