package transaction;

import serviceProviders.*;

public class RefundTransaction implements ITransaction{

	private IService service;
	private String transactionId;
	private static int counter=0;
	private double amount;
	public  RefundTransaction(IService service,double amount) 
	{
		counter++;
		transactionId="2"+Integer.toString(counter);
		this.service = service;
		this.amount=amount;
	}
	public String getID()
	{return transactionId;}
		
	
	
	
	@Override
	public String toString()
	{

		return "Transaction ID is "+ transactionId +("\n")+ "amount is "+ amount +"\n" +"provider is "+ service.getClass().getSimpleName() ;
		
	}
}
