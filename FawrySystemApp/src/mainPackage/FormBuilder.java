package mainPackage;

import java.util.ArrayList;

public class FormBuilder {
	Form form;
	String name;
	ArrayList<UIElements> elements = new ArrayList<UIElements>();
	
	public void buildTextField(String name)
	{
		elements.add(new TextField(name));
	}
	public void buildDropDownField(String name,int noOfFields,ArrayList<Object> array)
	{
		elements.add(new DropDownField(name,noOfFields,array));
		
	}
	public Form Build()
	{
		return (new Form(name,elements));
	}
	public void addName(String name) {
		this.name=name;
		
	}
	
}
