
package mainPackage;
import serviceProviders.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserController{

    User user;
    File file= new File("users.txt");
    ArrayList <IService> servicesList= new ArrayList<IService>();
    
    public UserController (ArrayList <IService> servicesList) {
    	
        this.servicesList=servicesList;
    }
    public void searchforService(String service)
    {
    	ArrayList<String> results = new ArrayList<String>();
    	
    	service = service.trim().toLowerCase();
    	
    	int count = 0;
    	 	
    	for(int i = 0 ; i< servicesList.size() ; i++)
    	{
    		if(servicesList.get(i).getClass().getSimpleName().toLowerCase().contains(service))
    		{
    			System.out.println((count+1) + " . "+ servicesList.get(i).getClass().getSimpleName()); //THIS IS PRINTING NOT INCREMENTING
    			count++;
    		}
    	}
    	
    	if(count == 0)
    	{
    		System.out.println("Nothing matches your query	:'( ");
    	}
    	
    }

public void signUp(User user) throws IOException 
{
	
	FileWriter fr = null;
	BufferedWriter br = null;
	PrintWriter pr = null;
	Scanner read=new Scanner(file);
	String tempUsername="";
	try {
		boolean check=true;
		// to append to file, you need to initialize FileWriter using below constructor
		fr = new FileWriter(file, true);
		br = new BufferedWriter(fr);
		
		pr = new PrintWriter(br);
		while(read.hasNext())
		{
			 tempUsername=read.nextLine();
             String [] values=tempUsername.split("-");
             if(values[0].equals(user.getUsername()))
             {
            	 System.out.println("USER ALREADY EXISTS! ");
 				 pr.close();
				 br.close();
				 fr.close();
				 check = false;
				 
             }
             
		}
		if(check)
		{
			pr.println(user.getUsername()+"-"+user.getPassword()+"-"+user.getEmail());		
			System.out.println("You are now part of our system ;-) ");
		}
		
	} catch (IOException e) {
		e.printStackTrace();
		
	} finally {
		try {
			pr.close();
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}
    public boolean login(User user)
    { 
         boolean found=false;
         String tempUsername="";
        
         try {

             Scanner read=new Scanner(file);//object to read the file
            

             while (read.hasNext())
             {
                 tempUsername=read.nextLine();
                  String [] values=tempUsername.split("-");
                 if(values[0].equals(user.getUsername())&&values[1].equals(user.getPassword()))
                 {
                     found=true;
                 }

           }
             read.close();
       
         }



         catch(Exception e) {
           
             e.printStackTrace();
         }
        return found;




    }}

