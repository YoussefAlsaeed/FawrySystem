package mainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserController{

    User user;
    File file= new File("users.txt");
 
    public UserController () {
        
    }
    public void signUp(User user) throws IOException 
    {
    	
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(user.getUsername()+"-"+user.getPassword()+"-"+user.getEmail());
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

