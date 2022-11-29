package mainPackage;

import java.util.ArrayList;

public class DropDownField implements UIElements {

	String name;
	int noOfFields;
	ArrayList<Object> array;
	public DropDownField(String name, int noOfFields, ArrayList<Object> array) {
		this.name=name;
		this.noOfFields=noOfFields;
		this.array=array;
	}
	public void print() {
		System.out.println("**********************************");
		System.out.println("This is a drop down field\n please choose from these options");
		for(int i=0;i<array.size();i++)
		{
			System.out.println(array.get(i));
		}
	}

}
