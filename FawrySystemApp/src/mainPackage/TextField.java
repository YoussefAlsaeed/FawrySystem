package mainPackage;

import java.util.Scanner;

public class TextField implements UIElements {

	String name;
	public TextField(String name) {
		this.name=name;
	}
	public void print()
	{
		System.out.println("**********************************");
		System.out.println("This is a Text Field, please enter ur "+name+":");
	}
	public String returnValue()
	{
		Scanner sc=new Scanner(System.in);
		
		name=sc.next();
		return name;
		
	}

}
