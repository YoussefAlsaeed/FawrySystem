package abstractFactory;

import serviceProviders.IService;

import java.util.ArrayList;

import command.*;
import composite.*;
import serviceProviders.*;

public class NGOFactory extends ProviderFactory  {

//	Form form;
//	Command c;
//	//ArrayList<UIElements> elements = new ArrayList<UIElements>();
	@Override
	public IService createServiceProvider(String type) {
	
		 if(type.toLowerCase().contains("donation"))
		 {
			 form.setName("NGO donation ");
			 //donationCommand.setForm(form);
			 return new NgosDonations(form,donationCommand);
		 }

		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
