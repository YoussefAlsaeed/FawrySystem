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
			 return new NgosDonations(form,c);
		 }

		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
