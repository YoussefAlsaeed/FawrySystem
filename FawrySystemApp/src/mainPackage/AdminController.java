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
	
	Admin admin=new Admin();

    IRefundRequest refundRequestStrategy;
    
    public AdminController()
    {
    	
    }
    
    
	public boolean viewRefundRequests()
	{
		for( Entry<String, User> entry :admin.getRefundRequests().entrySet() )
		{
		    System.out.println(entry.getValue().getUsername()+ " --- "  + " Transaction ID: " +entry.getKey() );
		    System.out.println("-----------------------------");
		}
	//	System.out.println(refundRequests);
		return false;
		
	}
	
	
	public void listallTransactions()
	{
		for (int i = 0; i <admin.getTransactionList().size(); i++)
		{
			System.out.println(admin.getTransactionList().get(i));
			System.out.println("-----------------------------");
		}
	}
	

	public void listuserTransactions(String user)
	{
		for (int i = 0; i <admin.getUserList().size(); i++)
		{
			if(admin.getUserList().get(i).getUsername().equals(user)) {
				System.out.println(admin.getUserList().get(i));
				System.out.println("-----------------------------");
			}
				
		}
	}

	

	public void addToRefundRequests(User user, String transactionID) {
		for(int i=0;i<admin.getTransactionList().size();i++)
		{
			if(admin.getTransactionList().get(i).getID().equals(transactionID))
			{
				admin.addToRefundRequests(transactionID, user);
			}
		}
		
	}

	public void addToTransactions(ITransaction t, User user) {
		admin.addTransaction(t);
		if(!(admin.getUserList().contains(user)))
		   admin.addUser(user);
	}
	
	public void acceptTransaction(String transactionID,User user)
	{    
		user =admin.getRefundRequests().get(transactionID);
		ITransaction acceptedTransaction=null;
		for(int i=0;i<admin.getTransactionList().size();i++)
		{
			if(admin.getTransactionList().get(i).getID().equals(transactionID))
			{
				acceptedTransaction = admin.getTransactionList().get(i);
			
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

		System.out.println(admin.getRefundRequests().remove(t.getID(),user));
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