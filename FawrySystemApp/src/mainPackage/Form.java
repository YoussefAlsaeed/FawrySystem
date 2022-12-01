package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Form {
	String name;
	public static int counter=0;
	int formID;
	ArrayList<UIElements> elements = new ArrayList<UIElements>();
	public Form(String name,ArrayList<UIElements> elements)
	{   this.formID=counter;
		this.name=name;
		this.elements=elements;
		counter++;
	}
	public void print()
	{
		System.out.println("This is the "+name +" form");
		for(int i=0;i<elements.size();i++)
		{
			elements.get(i).print();
		}
		
	}
	public void fillForm()
	{
		System.out.println("This is the "+name +" form");
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<elements.size();i++)
		{
			elements.get(i).print();
			list.add(elements.get(i).returnValue());
		}
		
	
	}
	
	
}
