package mainPackage;

import java.util.ArrayList;

import serviceProviders.IService;
import transaction.ITransaction;

public class User 
{
			
		String username;
		String password;
		String email;
		ArrayList <ITransaction> TransactionList= new ArrayList<ITransaction>();
		public double CreditCard; 
		public double wallet;
		
		public User ()
		{
		}
		
		public void printTransaction()
		{
			if(TransactionList.size()==0)
			{
				System.out.println("No Transaction Yet");
				
			}
			else
			{
				for(int i = 0;i<TransactionList.size();i++)
				{
					System.out.println(TransactionList.get(i));
				}
			}
		}
		
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}

}
