package mainPackage;

import java.util.ArrayList;

import composite.*;

public class FormBuilder {
	Form form;
	String name;
	ArrayList<UIElements> elements = new ArrayList<UIElements>();
	
	public void buildTextField(String name)
	{
		form.addElement(new TextField(name));
	}
	public void buildDropDownField(String name,int noOfFields,ArrayList<Object> array)
	{
		form.addElement(new DropDownField(name,noOfFields,array));
		
	}
	public Form Build()
	{
		return (new Form(name));
	}
	public void addName(String name) {
		this.name=name;
		
	}
	
}
