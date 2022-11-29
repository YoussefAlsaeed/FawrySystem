package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		FormBuilder builder=new FormBuilder();
		String choice = "";
		Scanner scan = new Scanner(System.in);
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

			switch (choice) {
			
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
				f.print();
				break;
				
			
	}
		}

}
	}
