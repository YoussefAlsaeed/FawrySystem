package mainPackage;
import serviceProviders.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import composite.*;
import transaction.*;

public class AdminController {

	private HashMap<String,User> refundRequests=new HashMap<String,User>();
	private ArrayList <ITransaction>transactions=new ArrayList<ITransaction>();
	private ArrayList <User>users=new ArrayList<User>();

    IRefundRequest refundRequestStrategy;
    
    public AdminController()
    {
    	
    }
    
    
	public boolean viewRefundRequests()
	{
		for( Entry<String, User> entry : refundRequests.entrySet() )
		{
		    System.out.println(entry.getValue().getUsername()+ " --- "  + " Transaction ID: " +entry.getKey() );	
		}
	//	System.out.println(refundRequests);
		return false;
		
	}
	
	
	public void listallTransactions()
	{
		for (int i = 0; i < transactions.size(); i++)
		{
			System.out.println(transactions.get(i));
		}
	}
	

	public void listuserTransactions(String user)
	{
		for (int i = 0; i < users.size(); i++)
		{
			if(users.get(i).getUsername().equals(user))
				System.out.println(users.get(i));
		}
	}

	

	public void addToRefundRequests(User user, String transactionID) {
		for(int i=0;i<transactions.size();i++)
		{
			if(transactions.get(i).getID().equals(transactionID))
			{
				refundRequests.put(transactionID,user);
			}
		}
		
	}

	public void addToTransactions(ITransaction t, User user) {
		transactions.add(t);
		if(!(users.contains(user)))
		   users.add(user);	
	}
	
	public void acceptTransaction(String transactionID,User user)
	{    
		user =refundRequests.get(transactionID);
		ITransaction acceptedTransaction=null;
		for(int i=0;i<transactions.size();i++)
		{
			if(transactions.get(i).getID().equals(transactionID))
			{
				acceptedTransaction = transactions.get(i);
			
			}
		}
		refundRequestStrategy.refund(acceptedTransaction,user);
		refundedTransaction(acceptedTransaction, user);
	}
	
	public void refundedTransaction(ITransaction t, User user)
	{
		ITransaction transaction = new RefundTransaction(t.getAmount());
		user.addTransaction(transaction);
		addToTransactions(transaction,user);
		//refundRequests.put(transaction.getID(), null);
		
		System.out.println("THE IDD: "+t.getID());

		System.out.println(refundRequests.remove(t.getID(),user));
	//	refundRequests.replace(null, user);
		
		
	}
	public void setRefundRequest(IRefundRequest request) {
		this.refundRequestStrategy= request;
	}
	public IRefundRequest  RefundRequest() {
		return refundRequestStrategy;
	}


	public boolean checkTransactions(User user) {
		ArrayList<ITransaction>t=user.getTransactionList();
		if(t.size()>0){
			return true;
		}
		return false;
		
	}
	
	
	
	
	
}