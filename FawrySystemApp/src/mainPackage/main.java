package mainPackage;
import discountsDecorator.*;
import abstractFactory.*;
import composite.*;
import serviceProviders.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class main {

	public static void main(String[] args) throws IOException {
		FormBuilder builder=new FormBuilder();
		String choice = "";
		Scanner scan = new Scanner(System.in);
        String username;
        String password;
        String email;
        String TransactionID;
        ArrayList <IService> services = new ArrayList<>();
        ArrayList <User> users=new ArrayList<>();
        int counter=0;
        
        //Creating services using Factory Method
        
       // IService service;
        IServiceFactory fact = null;
        IService service;
        
      //  IServiceFactory fact=new MobileRechargeFactory();
      //  IService service=fact.createService("Vodafonemobile");
      //  service.pay();
//        IServiceFactory fact;
//        IService service;
    	/*fact = new DonationsFactory();
    	service = fact.createService();  	
    	services.add(service);
    	
    	fact = new LandlineFactory();
    	service = fact.createService();
    	services.add(service);
    	
    	fact = new MobileRechargeFactory();
    	service = fact.createService();  	
    	services.add(service);
    	
    	fact = new InternetPaymentFactory();
    	service = fact.createService();   	
    	services.add(service);
    	*/
        	
    	
        UserController userController = new UserController(services);
        AdminController adminController=new AdminController();
        
        ArrayList<Form> forms=new ArrayList<Form>();
		while (!choice.equals("4"))
		{
			System.out.println("* * * * * * * * * * * * * * * * * * ");

			System.out.println("registeration Menu: ");
			System.out.println();
			// System.out.println("1-Generate randoms slots");
			System.out.println("1-login as users");
			System.out.println("2-SignUp as users");
			System.out.println("3-login as admin");
			System.out.println();
			System.out.println("* * * * * * * * * * * * * * * * * * ");
			
			System.out.println("Enter your choice: ");
			choice = scan.next();// taking the user's choice
			
			
			switch(choice)
			{
			
			case"1":
				System.out.println("What is your username: ");
				 username=scan.next();
				 
			     System.out.println("What is your password: ");
			     password= scan.next();
				User user=new User();
				user.setPassword(password);
				user.setUsername(username);
				boolean found=false;
				if(userController.login(user))
                { 
					for(int i=0;i<users.size();i++)
                    {
                        if(users.get(i).getUsername().equals(username))
                        {
                            user=users.get(i);
                            found=true;
                        }
                    }
                    if(!found)
                    {
                        users.add(user);
                    }
					
                   boolean signedIn = true;
                   System.out.println("Login Successful");
                    
                    while(signedIn)
                    {
                        System.out.println("* * * * * * * * * * * * * * * * * * ");

                        System.out.println("User Menu: ");
                        System.out.println();
                        
                        System.out.println("1-Search for services");
                        System.out.println("2-View My Balance");  
                        System.out.println("3-Pay for services");
                        System.out.println("4- Request a refund");
                        System.out.println("5- Add to wallet from creditcard");
                        System.out.println("6-View my transactions history");
                        System.out.println("7-Log out"); 

                        System.out.println();
                        System.out.println("* * * * * * * * * * * * * * * * * * ");
                        
                        System.out.println("Enter your choice: ");
                        choice = scan.next();// taking the user's choice
                        
                        switch (choice)
                        {
                        case"1":
                            System.out.println("Enter the service you want to query for "); 
                            String service5 = scan.next();                    
                            userController.searchforService(service5);
                            break;
                        case "2":
                        	userController.viewBalance(user);
                        	break;
                     
                           
                        case"3":
                     
                            System.out.println("Enter the service you want to pay for");
                            System.out.println("your options is (MobileRecharge-InternetPayment-Donations-LandLine)");
                        	String serviceChoice=scan.next();
                     
                        	serviceChoice=serviceChoice.trim();
                        	if(serviceChoice.toLowerCase().contains("mobile"))
                        		fact=new MobileRechargeFactory();
                        	else if(serviceChoice.toLowerCase().contains("internet"))
                    			fact=new InternetPaymentFactory();
                        	else if(serviceChoice.toLowerCase().contains("donations"))
                    			fact=new DonationsFactory();
                        	else if(serviceChoice.toLowerCase().contains("landline"))
                    			fact=new LandLineFactory();
                        	//else System.out.println("no service with this type");
                        	else
                        	{ System.out.println("no service with this type");
                        		break;
                        	}
                        	System.out.println("Now please enter the provider");
                        	String provider=scan.next();
                        	//provider=provider.trim();
                        	
                        	service=fact.createService(provider);
//                        	if(service!=null) 
//                      	       service.pay();
//                        	else
//                        	   System.out.println("there is no provider with that type");
                        	
                        		
                      	    break;
                      	    
                        case"4":
                        	
                        	if(userController.viewUserTransactionHistory(user))
                        	{
                        		System.out.println("Enter the Transaction ID");
                        		TransactionID=scan.next();
                            	adminController.addToRefundRequests(user,TransactionID);
                            	System.out.println("Your request will be accepted/rejected by the admin");
                        	}
                        	
                        	break;
                        	
                        case"5":
                            userController.viewBalance(user);
                            System.out.println("Enter the amount you want to add to the wallet");
                            double n=scan.nextDouble();
                            userController.addToWallet(n, user, adminController);
                          
                            break;
                        case"6":
                        	System.out.println("-----------------------------");
                        	System.out.println("Transaction History:\n");
                            userController.viewUserTransactionHistory(user);
                            System.out.println("-----------------------------");
                            break;
                      
                        case"7":
                            System.out.println("You are logged out ! ");
                            signedIn = false;
                            break;
                           
                        	
                       
       }}}
                     
				
				else
					 System.out.println("there is no user with info please sign up first");
				break;
				
			case"2":
				   System.out.println("What is your username: ");
				  username=scan.next();
				  
			     System.out.println("What is your password: ");
			     password= scan.next();
			     
			     System.out.println("What is your email: ");
			     email= scan.next();
			     User user2=new User();
			     user2.setUsername(username);
			     user2.setPassword(password);
			     user2.setEmail(email);
			      userController.signUp(user2);
				break;
				
			case"3":
				boolean signedIn = true;
                System.out.println("Login Successful");
                
                while(signedIn)
                {
                	System.out.println("* * * * * * * * * * * * * * * * * * ");

                    System.out.println("Admin Menu: ");
                    System.out.println();
                    
                    System.out.println("1-Edit a service provider form");
                    System.out.println("2-List a user transactions");
                    System.out.println("3-List all transactions");
                    System.out.println("4-Add discounts");
                    System.out.println("5-Review Refund Requests");
                    System.out.println("6-Log out"); 

                    System.out.println();
                    System.out.println("* * * * * * * * * * * * * * * * * * ");
                    
                    System.out.println("Enter your choice: ");
                    choice = scan.next();// taking the user's choice
                    
                    switch (choice)
                    {
                    case"5":
                    	adminController.viewRefundRequests();
                    	System.out.println("Choose the transaction you want to process ");
                    	String chooseTransaction;
                    	chooseTransaction = scan.next();
                    	
                    	System.out.println("Choose '1' to Accept or '2' to decline ");
                    	String acceptance = scan.next();
                    	
                    	if(acceptance.equals("1"))
                    	{
                    		adminController.acceptTransaction(chooseTransaction);
                    	}
                    	else
                    	{
                    		System.out.println("REJECTED YALAAA");
                    	}

                    	break;
                    	
                    case"6":
                    	signedIn = false;
                    	break;
                    
                    case"1":
                    	choice= "";
    					while (!choice.equals("3")) {
    						System.out.println("* * * * * * * * * * * * * * * * * * ");
    	
    						System.out.println("Creation Menu: ");
    						System.out.println();
    						System.out.println("1-Add drop down field");
    						System.out.println("2-Add Text Field");
    						System.out.println("3-Create Form");
    						System.out.println();
    						System.out.println("* * * * * * * * * * * * * * * * * * ");
    	
    						System.out.println("Enter your choice: ");
    						choice = scan.next();// taking the user's choice
    	
    						switch (choice)
    						{
    						
    						case "1": 
    							System.out.println("Enter the name of the drop down field: ");
    							String name=scan.next();
    							System.out.println("Enter the number of the fields: ");
    							int no=scan.nextInt();
    							ArrayList<Object> array=new ArrayList<Object>();
    							for(int i=0;i<no;i++)
    							{
    								System.out.println("Enter value "+(i+1)+" : ");
    								array.add(scan.next());
    							}
    							builder.buildDropDownField(name, no, array);
    							break;
    						
    						case "2": 
    							System.out.println("Enter the name of the drop down field: ");
    							name=scan.next();
    							builder.buildTextField(name);
    							break;
    						case "3":
    							System.out.println("Please enter the name of the form: ");
    							name=scan.next();
    							builder.addName(name);
    							Form f=builder.Build();
    							f.view();
    							forms.add(f);
    							
    							break;
							
					
    						}
	    				}					
                    }				
                }
			}
		}
	}
}