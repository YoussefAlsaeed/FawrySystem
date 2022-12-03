package composite;

import java.util.ArrayList;

public class DropDownField implements UIElements {

	String dropDownField;
	int noOfFields;
	ArrayList<Object> array;
	public DropDownField(String dropDownField,int noOfFields, ArrayList<Object> array)
	{
		this.noOfFields=noOfFields;
		this.array=array;
		this.dropDownField=dropDownField;
	}
	@Override
	public void view() {
		
		System.out.println("This is ("+dropDownField+") drop down field\n <please choose from these options>");
		for(int i=0;i<array.size();i++)
		{
			System.out.println(array.get(i));
		}
		System.out.println("---------------------------------------");

	}
	public void incrementNoOfFields(int noOfFields)
	{
		this.noOfFields+=noOfFields;
	}
	public void addFields(int n,ArrayList<Object> newFields)
	{
		this.incrementNoOfFields(n);
		for(int i=0;i<n;i++)
		{
			array.add(newFields.get(i));
		}
		
	}

}
