package mainPackage;

import java.util.ArrayList;

public class Form {
	String name;
	ArrayList<UIElements> elements = new ArrayList<UIElements>();
	public Form(String name,ArrayList<UIElements> elements)
	{
		this.name=name;
		this.elements=elements;
	}
	public void print()
	{
		System.out.println("This is the "+name +" form");
		for(int i=0;i<elements.size();i++)
		{
			elements.get(i).print();
		}
	}
}
