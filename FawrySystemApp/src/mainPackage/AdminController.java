package mainPackage;
import serviceProviders.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import composite.*;
import transaction.*;

public class AdminController {

	private HashMap<String,ITransaction> refundRequests=new HashMap<String,ITransaction>();
	private ArrayList <ITransaction>transactions=new ArrayList<ITransaction>();
	
	public boolean viewRefundRequests()
	{
		for( Entry<String, ITransaction> entry : refundRequests.entrySet() ){
		    System.out.println( entry.getKey() + " --- " + entry.getValue() );
		}
		return false;
		
	}
	
	public void addServiceProvider(Form form,String name,IService service)
	{
		
	}

	public void addToRefundRequests(User user2, String transactionID) {
		for(int i=0;i<transactions.size();i++)
		{
			if(transactions.get(i).getID().equals(transactionID))
			{
				refundRequests.put(user2.getUsername(),transactions.get(i));
			}
		}
		
	}

	public void addToTransactions(ITransaction t) {
		transactions.add(t);
		
	}
	
	
}
