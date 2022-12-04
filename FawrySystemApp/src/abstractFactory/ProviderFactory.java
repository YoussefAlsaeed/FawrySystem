package abstractFactory;

import java.util.ArrayList;

import command.*;
import composite.*;
import serviceProviders.IService;

public abstract class ProviderFactory {
	Form form=new Form();
	MobileRechargeCommand mobileRechargeCommand= new MobileRechargeCommand();
	InternetCommand internetCommand=new InternetCommand();
	LandlineCommand landlineCommand=new LandlineCommand();
	DonationsCommand donationCommand=new DonationsCommand();
	
	String formName;
	ArrayList<UIElements> elements = new ArrayList<UIElements>();
	public ProviderFactory()
    {
        createForm();
    }
	abstract public void setFormName(String name);

	public Form createForm() {
		ArrayList<Object>fields=new ArrayList<Object>();
		fields.add("CreditCard");
		DropDownField d=new DropDownField("Payment Method",1,fields);
		TextField t1=new TextField("Amount");
		TextField t2=new TextField("Mobile Number");
		elements.add(d);
		elements.add(t1);
		elements.add(t2);
		for(int i=0;i<elements.size();i++)
		{
			form.addElement(elements.get(i));
		}
		return form;
		
	}
	/*public void nullForm()
	{
		for(int i=0;i<elements.size();i++)
		{
			elements.remove(elements.get(i));
		}
	}*/

	public void editForm(ArrayList<UIElements> array)
	{
		for(int i=0;i<array.size();i++)
		{
			elements.add(array.get(i));
		}
	}
	public int getNoOfElements()
	{
		return elements.size();
	}
	abstract public IService createServiceProvider(String type) ;
}
