package transaction;

import serviceProviders.*;

public class RefundTransaction implements ITransaction{

	private String transactionId;
	private static int counter=0;
	private double amount;
	public  RefundTransaction(double amount) 
	{
		counter++;
		transactionId="2"+Integer.toString(counter);
		this.amount=amount;
	}
	
	public String getID()
	{return transactionId;}
		
	
	
	
	@Override
	public String toString()
	{

		return "\nTransaction ID is "+ transactionId +("\n")+ "amount refunded to user: "+ amount +"\n" ;
		
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
}
