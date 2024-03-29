package mainPackage;
import discountsDecorator.*;
import composite.*;
import serviceProviders.*;
import transaction.ITransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import abstractFactory.*;
import refundRequestStrategy.*;



public class main {

	public static void main(String[] args) throws IOException {
		String choice = "";
		Scanner scan = new Scanner(System.in);
        String username;
        String password;
        String email;
        String TransactionID;
        ArrayList <IService> services = new ArrayList<>();
        ArrayList <User> users=new ArrayList<>();
        int counter=0;
        
        //Factories
        
        WeFactory we=new WeFactory();
        VodafoneFactory vodafone=new VodafoneFactory();
        OrangeFactory orange=new OrangeFactory();
        EtisalatFactory etisalat=new EtisalatFactory();
        CancerHospitalFactory cancerhospital=new  CancerHospitalFactory(); 
        NGOFactory ngo=new NGOFactory(); 
        SchoolProviderFactory school=new SchoolProviderFactory();
        MonthlyReceiptFactory mr=new MonthlyReceiptFactory();
        QuarterReceiptFactory qr=new QuarterReceiptFactory();
        
        
        
       
        
        //Creating services providers using Factories
        
        IService service;
        
        services.add(we.createServiceProvider("mobile"));
        services.add(we.createServiceProvider("internet"));
        services.add(vodafone.createServiceProvider("mobile"));
        services.add(vodafone.createServiceProvider("internet"));
        services.add(orange.createServiceProvider("mobile"));
        services.add(orange.createServiceProvider("internet"));
        services.add(etisalat.createServiceProvider("mobile"));
        services.add(etisalat.createServiceProvider("internet"));
        services.add(cancerhospital.createServiceProvider("donation"));
        services.add(ngo.createServiceProvider("donation"));
        services.add(school.createServiceProvider("donation"));
        services.add(mr.createServiceProvider("landline"));
        services.add(qr.createServiceProvider("landline"));
        

       
        	
    	
        UserController userController = new UserController(services);
      
        AdminController adminController=new AdminController();
        User user;

        IRefundRequest r;
        ArrayList<Form> forms=new ArrayList<Form>();
		while (!choice.equals("4"))               // Main menu
		{
			System.out.println("* * * * * * * * * * * * * * * * * * ");

			System.out.println("Registeration Menu: ");
			System.out.println();
			System.out.println("1-Login as user");
			System.out.println("2-SignUp as user");
			System.out.println("3-Login as admin");
			System.out.println();
			System.out.println("* * * * * * * * * * * * * * * * * * ");
			
			System.out.println("Enter your choice: ");
			choice = scan.next();// taking the user's choice
			
			
			switch(choice)
			{
			
			case"1":
				
				System.out.println("What is your username: ");
				username=scan.next();
				User loginUser = new User();
			    System.out.println("What is your password: ");
			    password= scan.next();
			    loginUser.setPassword(password);
			    loginUser.setUsername(username);
				boolean found=false;
				if(userController.login(loginUser))
                { 
					for(int i=0;i<users.size();i++)            //Checks if the user already exists in the system
                    {
                        if(users.get(i).getUsername().equals(username))
                        {
                        	loginUser=users.get(i);
                            found=true;
                        }
                    }
                    if(!found)
                    {
                        users.add(loginUser); 
                    }
					
                   boolean signedIn = true;
                   System.out.println("Login Successful");  // If the user exists he is redirected to User menu
                    
                    while(signedIn)
                    {
                        System.out.println("* * * * * * * * * * * * * * * * * * ");

                        System.out.println("User Menu: ");
                        System.out.println();
                        
                        System.out.println("1-Search for services");
                        System.out.println("2-View My Balance");  
                        System.out.println("3-Pay for services");
                        System.out.println("4- Request a refund");
                        System.out.println("5- Add to wallet from credit card");
                        System.out.println("6-View my transactions history");
                        System.out.println("7-List discounts");
                        System.out.println("8-Log out"); 

                        System.out.println();
                        System.out.println("* * * * * * * * * * * * * * * * * * ");
                        
                        System.out.println("Enter your choice: ");
                        choice = scan.next();// taking the user's choice
                        
                        switch (choice)
                        {
                        case"1":
                            System.out.println("Enter the service you want to search for "); 
                            String searchedForService = scan.next();                    
                            userController.searchforService(searchedForService); // Calls function with service name to get the query results
                            break;
                            
                        case "2":
                        	userController.viewBalance(loginUser); // Views balance of current user
                        	break;
                     
                           
                        case"3":
                        	
                        	System.out.println("Enter the service you want to pay for");
                            System.out.println("Your options are: "
                            		+"\n"
                            		+ "\n-mobile recharge"
                            		+ "\n-internet Payment"
                            		+ "\n-donations"
                            		+ "\n-landLine");
                            String userChoice=scan.next();
                            if(userChoice.contains("mobile")||userChoice.contains("internet")) // Choosing the service and service provider to pay for
                            {
                            	if(userChoice.contains("mobile"))
                            		userChoice="mobile";
                            	else if(userChoice.contains("internet"))
                            		userChoice="internet";
                    
                            	 System.out.println("Enter the provider you want to pay for");
                            	 System.out.println("your options are "
                            			+"\n"
                            	 		+ "\n- we"
                            	 		+ "\n- vodafone"
                            	 		+ "\n- orange"
                            	 		+ "\n- etislat");
                            	 String providerChoice=scan.next();
                            	 if(providerChoice.toLowerCase().contains("we"))
                            		 service=we.createServiceProvider(userChoice);
                             	else if(providerChoice.toLowerCase().contains("orange"))
                             		service=orange.createServiceProvider(userChoice);
                             	else if(providerChoice.toLowerCase().contains("vodafone"))
                             		service=vodafone.createServiceProvider(userChoice);
                             	else if(providerChoice.toLowerCase().contains("etisalat"))
                             		service=etisalat.createServiceProvider(userChoice);
                             	else
                              	{   System.out.println("no provider with this type");
                           		    break;
                                }
                            	 
                           }
                            
                            else if(userChoice.contains("donation"))
                            {
                            	 System.out.println("Enter the provider you want to pay for");
                            	 System.out.println("your options are "
                             			+"\n"
                             	 		+ "\n- school donations"
                             	 		+ "\n- ngos donations"
                             	 		+ "\n- cancer hospital donations "
                             	 		);
                            	 
                            	 String providerChoice=scan.next();
                            	 if(providerChoice.toLowerCase().contains("school"))
                            		 service=school.createServiceProvider(userChoice);
                             	else if(providerChoice.toLowerCase().contains("ngo"))
                             		service=ngo.createServiceProvider(userChoice);
                             	else if(providerChoice.toLowerCase().contains("cancer"))
                             		service=cancerhospital.createServiceProvider(userChoice);
                             	else
                              	{   System.out.println("no provider with this type");
                           		    break;
                                }
                            }
                            else if(userChoice.contains("landline"))
                            {
                            	 System.out.println("Enter the provider you want to pay for");
                            	 System.out.println("your options are "
                              			+"\n"
                              	 		+ "\n- monthly receipt"
                              	 		+ "\n- quarter reciept"
                             	 		);
                            	 
                            	 String providerChoice=scan.next();
                            	 if(providerChoice.toLowerCase().contains("monthly"))
                            		 service= mr.createServiceProvider(userChoice);
                             	else if(providerChoice.toLowerCase().contains("quarter"))
                             		service=qr.createServiceProvider(userChoice);
                             	else
                              	{   System.out.println("no provider with this type");
                           		    break;
                                }
                            }
                            else 
                        	{  
                        		System.out.println("no service with this type");
                   		        break;
                            }
                            adminController.addToTransactions(service.pay(loginUser), loginUser); // Calling pay method of the chosen service and saving the transaction.         
                            
                           break;
                           
                 
           		
                      	  
                      	    
                        case"4":
                        	
                        	// Checks first if the user has any transactions then views the user transactions.
                        	
                        	if(userController.viewUserTransactionHistory(loginUser))
                        	{
                        		System.out.println("Enter the Transaction ID");
                        		TransactionID=scan.next();   //Choosing which transaction will be refunded.
                            	adminController.addToRefundRequests(loginUser,TransactionID);  // Sending the refund request to the admin
                            	System.out.println("Your request will be accepted/rejected by the admin");
                        	}
                        	
                        	break;
                        	
                        case"5":
                            userController.viewBalance(loginUser);  // Views the user's current balance
                            System.out.println("Enter the amount you want to add to the wallet");
                            double n=scan.nextDouble();
                            userController.addToWallet(n, loginUser, adminController); // Adding money from credit card to current user's wallet and saving the transaction.
                          
                            break;
                        case"6":
                        	System.out.println("-----------------------------");
                        	System.out.println("Transaction History:\n");
                            userController.viewUserTransactionHistory(loginUser); // Viewing the current user's transactions
                            System.out.println("-----------------------------");
                            break;
                            
                        case"7":
                        	userController.viewDiscounts();
                        	break;
                      
                        case"8":
                            System.out.println("You are logged out ! ");
                            signedIn = false;  // Exiting the menu
                            break;
                           
                        	
                       
       }}}
                     
				
				else
					 System.out.println("There is no user with info please sign up first");
				break;
				
			case"2":	 // Signing Up a new user in the system.
			    System.out.println("What is your username: ");
		        username=scan.next();
				  
			    System.out.println("What is your password: ");
			    password= scan.next();
			     
			    System.out.println("What is your email: ");
			    email= scan.next();
			    User user2=new User();
			    userController.setUserInfo(user2, username, password, email);
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
                    System.out.println("6-Add new payment methods to a form");
                    System.out.println("7-Log out"); 

                    System.out.println();
                    System.out.println("* * * * * * * * * * * * * * * * * * ");
                    
                    System.out.println("Enter your choice: ");
                    choice = scan.next();// taking the user's choice
                    
                    switch (choice)
                    {
                    
                    case"6":
                    	ProviderFactory provider = null ;
						
						System.out.println("Enter the provider form you want to edit");//Choosing which provider's form will be edited
						
						System.out.println("-> Vodafone <-");
						System.out.println("-> Orange <-");
						System.out.println("-> We <-");
						System.out.println("-> Etisalat <-");
						System.out.println("-> Schools <-");
						System.out.println("-> Ngo <-");
						System.out.println("-> Cancer <-");
						System.out.println("-> Monthly Reciept <-");
						System.out.println("-> Quarter Reciept <-");
						System.out.println("Enter the name of the provider: ");
						scan.nextLine();
						String providerName=scan.nextLine();
						if(providerName.toLowerCase().contains("vodafone"))
						{
						provider= vodafone;						
						}else if(providerName.toLowerCase().contains("orange"))
						{
						provider =orange;
						}else if(providerName.toLowerCase().contains("we"))
						{
						provider=we;
						}
						else if(providerName.toLowerCase().contains("etisalat"))
						{
						provider= etisalat;
						}	
						else if(providerName.toLowerCase().contains("schools"))
						{
						provider = school;
						}	
						else if(providerName.toLowerCase().contains("ngo"))
						{
						provider =ngo;
						}
						else if(providerName.toLowerCase().contains("cancer"))
						{
						provider = cancerhospital;
						}
						else if(providerName.toLowerCase().contains("monthly"))
						{
						provider =mr;
						}else if(providerName.toLowerCase().contains("quarter"))
						{
						provider =qr;
						
						} else {
							System.out.println("no provider with this type :( ");
							break;
						}
						System.out.println(">>>>>You are now editing <<<<<<");
						System.out.println("* * * * * * * * * * * * * * * * * * * * * * * ");
						System.out.println("Enter '1' to add (by wallet) /n Enter '2' to add (cash on delivery)");

						String s = null;
						s=scan.next();
						adminController.addPaymentMethodToProvider(provider, s);
						break;
						
						
                    	
                    case"1":
						
						provider = null ;
						
						System.out.println("Enter the provider form you want to edit");
						System.out.println("-> Vodafone <-");
						System.out.println("-> Orange <-");
						System.out.println("-> We <-");
						System.out.println("-> Etisalat <-");
						System.out.println("-> Schools <-");
						System.out.println("-> Ngo <-");
						System.out.println("-> Cancer <-");
						System.out.println("-> Monthly Reciept <-");
						System.out.println("-> Quarter Reciept <-");
						System.out.println("Enter the name of the provider: ");
						scan.nextLine();
						providerName=scan.nextLine();
						if(providerName.toLowerCase().contains("vodafone"))
						{
						provider= vodafone;						
						}else if(providerName.toLowerCase().contains("orange"))
						{
						provider =orange;
						}else if(providerName.toLowerCase().contains("we"))
						{
						provider=we;
						}
						else if(providerName.toLowerCase().contains("etisalat"))
						{
						provider= etisalat;
						}	
						else if(providerName.toLowerCase().contains("schools"))
						{
						provider = school;
						}	
						else if(providerName.toLowerCase().contains("ngo"))
						{
						provider =ngo;
						}
						else if(providerName.toLowerCase().contains("cancer"))
						{
						provider = cancerhospital;
						}
						else if(providerName.toLowerCase().contains("monthly"))
						{
						provider =mr;
						}else if(providerName.toLowerCase().contains("quarter"))
						{
						provider =qr;
						
						} else {
							System.out.println("no provider with this type :( ");
							choice="3";
						}
    					while (!choice.equals("3")) 
    					{
    						System.out.println("* * * * * * * * * * * * * * * * * * ");
    						System.out.println("Creation Menu: ");
    						System.out.println();
    						System.out.println("1-Add drop down field");
    						System.out.println("2-Add Text Field");
    						System.out.println("3-Exit");
    						System.out.println();
    						System.out.println("* * * * * * * * * * * * * * * * * * ");
    						System.out.println("Enter your choice: ");
    						choice = scan.next();
    						
    						
    						
    						switch(choice)
    						{
    						case"1":
    							    System.out.println(">>>You are now editing the "+providerName+" form<<<");
    	    						System.out.println("* * * * * * * * * * * * * * * * * * * * * * * ");

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
	    							
	    							provider.addDropDownFlield(name, no, array);
    							break;
    						case"2":
    							
    							System.out.println("Enter the name of the TextField: ");
    							name=scan.next();
    							provider.addTextField(name);
    							break;						

    						}
    					}
						break;
                    case"2":
                    	if (users.size()==0)
                            System.out.println("No transactions yet for any user");
                        else {
                    	System.out.println("These are the users that have transactions:\n");
                    	int countt=1;
                    	for (int i = 0; i < users.size(); i++) {
							if(adminController.checkTransactions(users.get(i))) {
								System.out.println((countt)+"-"+users.get(i).getUsername());
								countt++;
							}
							
						}
                    	System.out.println("\nEnter the username you want to list his transactions");
                    	String listedUser = scan.next();
                    	adminController.listuserTransactions(listedUser);
						
                        }
                    	
                    	break;
                    	
                    case"3":
                    	adminController.listallTransactions();
                    	break;
                    case"4":
                    	String c=null;
                    	System.out.println("Enter the service you want to add/remove discount from");
                    	System.out.println("Enter '1': Mobile Recharge Services");
                    	System.out.println("Enter '2': Internet payment Services");
                    	System.out.println("Enter '3': Landline Services");
                    	System.out.println("Enter '4': Donation Services");
                    	System.out.println("Enter '5': Overall discounts");
                    	c=scan.next();
                    	System.out.println("Enter '1' to add discount and '2' to remove discount");
                    	String c2=scan.next();
                    	if(c2.equals("1"))
                    	{
                    		System.out.println("Enter the discount percentage ex: 10 for 10%");
                    		double p=scan.nextDouble();
                        	adminController.addDiscount(c, p,userController);
                        	
                    	}
                    	else if(c2.equals("2"))
                    	{
                    		adminController.removeDiscount(c,userController);                 
                    	}
                    	break;
                    	
                    	
                    	
                    
                    case"5":
                    	user = new User();
                    	if(!adminController.viewRefundRequests()) {
                    		System.out.println("No refund requests");
                    		break;
                    	}
                    	System.out.println("Choose the transaction you want to process ");
                    	String chooseTransaction;
                    	ITransaction Transaction=null;
                    
                    	chooseTransaction = scan.next();
                    	if (chooseTransaction.charAt(0)=='2')
                    	{
                    		break;
                    	}
                    	
                    	System.out.println("Choose '1' to Accept or '2' to decline ");
                    	String acceptance = scan.next();
                    	String requestType=chooseTransaction.substring(0,1);
                    	
                    	if(acceptance.equals("1"))
                    	{   
                    		if(requestType.equals("0"))
                    		  adminController.setRefundRequest(new AddToWalletRefundRequest());
                    		
                    		
                    		
                    		else if(requestType.equals("1"))
                      		  adminController.setRefundRequest(new PaymentRefundRequest());
                    		
                    		adminController.acceptTransaction(chooseTransaction,user);
                    	}
                    	else
                    	{
                    		System.out.println("REJECTED refund");
                    	}

                    	break;
                    
                    	
                    case"7":
                    	signedIn = false;
                    	break;
                    	
                    }
                }
			}
		}
	}
}
		