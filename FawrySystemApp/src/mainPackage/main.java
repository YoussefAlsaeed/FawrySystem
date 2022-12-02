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
				User user2=new User();
				user2.setPassword(password);
				user2.setUsername(username);
				if(userController.login(user2))
                {
                    boolean signedIn = true;
                    System.out.println("Login Successful");
                    
                    while(signedIn)
                    {
                        System.out.println("* * * * * * * * * * * * * * * * * * ");

                        System.out.println("User Menu: ");
                        System.out.println();
                        
                        System.out.println("1-Search for services");
                        System.out.println("2-fillForm");  
                        System.out.println("3-Pay for services");
                        System.out.println("4- REquest a refund");
                        System.out.println("5-Log out"); 

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
                        	//forms.get(0).fillForm();
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
                        	userController.viewUserTransactionHistory(user2);
                        	System.out.println("Enter your Transaction ID");
                        	TransactionID=scan.next();
                        
                        	
                        	break;
                      
                        case"5":
                            System.out.println("You are logged out! mtgesh tany ");
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
			     User user=new User();
			     user.setUsername(username);
			     user.setPassword(password);
			     user.setEmail(email);
			      userController.signUp(user);
				break;
				
			case"3":
				choice= "";
				while (!choice.equals("3")) {
					System.out.println("* * * * * * * * * * * * * * * * * * ");

					System.out.println("Creation Menu: ");
					System.out.println();
					// System.out.println("1-Generate randoms slots");
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
