package mainPackage;
import discountsDecorator.*;
import oldAbstractFactory.*;
import composite.*;
import serviceProviders.*;
import transaction.ITransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import abstractFactory.*;




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
        WeFactory we=new WeFactory();
        VodafoneFactory vodafone=new VodafoneFactory();
        OrangeFactory orange=new OrangeFactory();
        EtisalatFactory etisalat=new EtisalatFactory();
        CancerHospitalFactory cancerhospital=new  CancerHospitalFactory(); 
        NGOFactory ngo=new NGOFactory(); 
        SchoolProviderFactory school=new SchoolProviderFactory();
        MonthlyReceiptFactory mr=new MonthlyReceiptFactory();
        QuarterReceiptFactory qr=new QuarterReceiptFactory();
        
        
        
       
        
        //Creating services using Factory Method
        
       // IService service;
      //  IServiceFactory fact = null;
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
        User user;

        IRefundRequest r;
        ArrayList<Form> forms=new ArrayList<Form>();
		while (!choice.equals("4"))
		{
			System.out.println("* * * * * * * * * * * * * * * * * * ");

			System.out.println("registeration Menu: ");
			System.out.println();
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
				User loginUser = new User();
			    System.out.println("What is your password: ");
			    password= scan.next();
			    loginUser.setPassword(password);
			    loginUser.setUsername(username);
				boolean found=false;
				if(userController.login(loginUser))
                { 
					for(int i=0;i<users.size();i++)
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
                        	userController.viewBalance(loginUser);
                        	break;
                     
                           
                        case"3":
                        	
                        	System.out.println("Enter the service you want to pay for");
                            System.out.println("your options is (mobile Recharge-internet Payment-donations-landLine)");
                            String serviceChoice=scan.next();
                            if(serviceChoice.contains("mobile")||serviceChoice.contains("internet"))
                            {
                            	if(serviceChoice.contains("mobile"))
                            		serviceChoice="mobile";
                            	else if(serviceChoice.contains("internet"))
                            		serviceChoice="internet";
                    
                            	 System.out.println("Enter the provider you want to pay for");
                            	 System.out.println("your options is (we-vodafone-orange-etislat)");
                            	 String providerChoice=scan.next();
                            	 if(providerChoice.toLowerCase().contains("we"))
                            		 service=we.createServiceProvider(serviceChoice);
                             	else if(providerChoice.toLowerCase().contains("orange"))
                             		service=orange.createServiceProvider(serviceChoice);
                             	else if(providerChoice.toLowerCase().contains("vodafone"))
                             		service=vodafone.createServiceProvider(serviceChoice);
                             	else if(providerChoice.toLowerCase().contains("etisalat"))
                             		service=etisalat.createServiceProvider(serviceChoice);
                             	else
                              	{   System.out.println("no provider with this type");
                           		    break;
                                }
                            	 
                           }
                            
                            else if(serviceChoice.contains("donation"))
                            {
                            	 System.out.println("Enter the provider you want to pay for");
                            	 System.out.println("your options is (schooldonations-ngosDonations-cancerhospitalDonations)");
                            	 String providerChoice=scan.next();
                            	 if(providerChoice.toLowerCase().contains("school"))
                            		 service=school.createServiceProvider(serviceChoice);
                             	else if(providerChoice.toLowerCase().contains("ngo"))
                             		service=ngo.createServiceProvider(serviceChoice);
                             	else if(providerChoice.toLowerCase().contains("cancer"))
                             		service=cancerhospital.createServiceProvider(serviceChoice);
                             	else
                              	{   System.out.println("no provider with this type");
                           		    break;
                                }
                            }
                            else if(serviceChoice.contains("landline"))
                            {
                            	 System.out.println("Enter the provider you want to pay for");
                            	 System.out.println("your options is (monthly receipt-quarter reciept)");
                            	 String providerChoice=scan.next();
                            	 if(providerChoice.toLowerCase().contains("monthly"))
                            		 service= mr.createServiceProvider(serviceChoice);
                             	else if(providerChoice.toLowerCase().contains("quarter"))
                             		service=qr.createServiceProvider(serviceChoice);
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
                            adminController.addToTransactions(service.pay(loginUser), loginUser);
                            	
                            	
                            	
                            
                            
                           break;
                           
                 
           		
                      	  
                      	    
                        case"4":
                        	
                        	if(userController.viewUserTransactionHistory(loginUser))
                        	{
                        		System.out.println("Enter the Transaction ID");
                        		TransactionID=scan.next();
                            	adminController.addToRefundRequests(loginUser,TransactionID);
                            	System.out.println("Your request will be accepted/rejected by the admin");
                        	}
                        	
                        	break;
                        	
                        case"5":
                            userController.viewBalance(loginUser);
                            System.out.println("Enter the amount you want to add to the wallet");
                            double n=scan.nextDouble();
                            userController.addToWallet(n, loginUser, adminController);
                          
                            break;
                        case"6":
                        	System.out.println("-----------------------------");
                        	System.out.println("Transaction History:\n");
                            userController.viewUserTransactionHistory(loginUser);
                            System.out.println("-----------------------------");
                            break;
                      
                        case"7":
                            System.out.println("You are logged out ! ");
                            signedIn = false;
                            break;
                           
                        	
                       
       }}}
                     
				
				else
					 System.out.println("There is no user with info please sign up first");
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
						
						System.out.println("Enter the provider form you want to edit");
						String providerName=scan.next();
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
							System.out.println("No provider from :( ");
							break;
						}
						System.out.println("How many payment methods to you want to add?");
						int num=scan.nextInt();
						 //BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
						for(int i=0;i<num;i++)
						{
							System.out.println("Enter payment method ("+(i+1)+") :");
							String s="";
							scan.nextLine();
							s=scan.nextLine();
							provider.addPaymentMethod(s);
						}
						break;
						
                    	
                    case"1":
						
						provider = null ;
						
						System.out.println("Enter the provider form you want to edit");
						providerName=scan.next();
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
							System.out.println("No provider from :( ");
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
    							    System.out.println("you are now editing the "+providerName+" form");
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
	    							
	    							provider.buildDropDownFlield(name, no, array);
    							break;
    						case"2":
    							
    							System.out.println("Enter the name of the TextField: ");
    							name=scan.next();
    							provider.buildTextField(name);
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
                    	System.out.println("Enter 1: Mobile Recharge Services");
                    	System.out.println("Enter 2: Internet payment Services");
                    	System.out.println("Enter 3: Landline Services");
                    	System.out.println("Enter 4: Donation Services");
                    	System.out.println("Enter 5: Overall discounts");
                    	c=scan.next();
                    	System.out.println("Enter '1' to add discount and '2' to remove discount");
                    	String c2=scan.next();
                    	if(c2.equals("1"))
                    	{
                    		System.out.println("Enter the discount percentage ex: 10 for 10%");
                    		double p=scan.nextDouble();
                        	if(c.equals("1"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		MobileRechargeDiscount.setDiscountPercentage(p/100);
                        		System.out.println(MobileRechargeDiscount.getDis()); 
                        		

                        	}
                        	else if(c.equals("2"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		InternetDiscount.setDiscountPercentage(p/100);
                        		System.out.println(InternetDiscount.getDis()); 
                        	}
                        	else if(c.equals("3"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		LandLineDiscount.setDiscountPercentage(p/100);
                        		System.out.println(LandLineDiscount.getDis()); 
                        	}
                        	else if(c.equals("4"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		DonationsDiscount.setDiscountPercentage(p/100);
                        		System.out.println(DonationsDiscount.getDis()); 
                        	}
                        	else if(c.equals("5"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		OverallDiscount.setDiscountPercentage(p/100);
                        		System.out.println(OverallDiscount.getDis()); 
                        	}
                        	else System.out.println("Invalid choice");
                        	
                    	}
                    	else if(c2.equals("2"))
                    	{
                 
                        	if(c.equals("1"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		MobileRechargeDiscount.setDiscountPercentage(0.0);
                        		System.out.println(MobileRechargeDiscount.getDis()); 
                        		

                        	}
                        	else if(c.equals("2"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		InternetDiscount.setDiscountPercentage(0.0);
                        		System.out.println(InternetDiscount.getDis()); 
                        	}
                        	else if(c.equals("3"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		LandLineDiscount.setDiscountPercentage(0.0);
                        		System.out.println(LandLineDiscount.getDis()); 
                        	}
                        	else if(c.equals("4"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		DonationsDiscount.setDiscountPercentage(0.0);
                        		System.out.println(DonationsDiscount.getDis()); 
                        	}
                        	else if(c.equals("5"))
                        	{
                        		//MobileRechargeDiscount d=new MobileRechargeDiscount(null);
                        		OverallDiscount.setDiscountPercentage(0.0);
                        		System.out.println(OverallDiscount.getDis()); 
                        	}
                        	else System.out.println("Invalid choice");
                        	
                    	}
                    	break;
                    	
                    	
                    	
                    
                    case"5":
                    	user = new User();
                    	adminController.viewRefundRequests();
                    	System.out.println("Choose the transaction you want to process ");
                    	String chooseTransaction;
                    	ITransaction Transaction=null;
                    
                    	chooseTransaction = scan.next();
                    	
                    	System.out.println("Choose '1' to Accept or '2' to decline ");
                    	String acceptance = scan.next();
                    	
                    	if(acceptance.equals("1"))
                    	{   adminController.setRefundRequest(new AddToWalletRefundRequest());
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
		