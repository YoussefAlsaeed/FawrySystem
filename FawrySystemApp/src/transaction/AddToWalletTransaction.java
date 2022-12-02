package transaction;

import serviceProviders.IService;

public class AddToWalletTransaction implements ITransaction 
{
	private IService service;
	private String TransactionId;
	private int counter;
	private int amount;
	public  AddToWalletTransaction(IService service,int amount) 
	{
		counter++;
		TransactionId="1"+Integer.toString(counter);
		this.service = service;
	}
		
	
	
	
	@Override
	public String toString()
	{

		
		return "Transaction ID is "+ TransactionId +("\n")+ "amount is "+ amount +"\n" +"provider is "+ service.getClass().getSimpleName() ;
		
	}
	
}
