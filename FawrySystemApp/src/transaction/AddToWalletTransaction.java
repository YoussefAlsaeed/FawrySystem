package transaction;

import serviceProviders.IService;

public class AddToWalletTransaction implements ITransaction 
{

	private String TransactionId;
	private static int counter=0;
	private double amount;
	public  AddToWalletTransaction(double amount) 
	{
		counter++;
		TransactionId="0"+Integer.toString(counter);
		this.amount=amount;
	}
		
	

	@Override
	public String toString()
	{

		
		return "Transaction ID is "+ TransactionId +"---" +" amount is "+ amount +"\n";
		
	}


	@Override
	public String getID() {
		return TransactionId;
	}
	
}
