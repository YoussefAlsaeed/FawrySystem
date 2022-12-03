package abstractFactory;

import serviceProviders.IService;

import java.util.ArrayList;

import command.*;
import composite.*;
import serviceProviders.*;

public class WeFactory extends ProviderFactory  {

//	Form form;
//	Command c;
//	//ArrayList<UIElements> elements = new ArrayList<UIElements>();
	@Override
	public IService createServiceProvider(String type) {
	
		
		 if(type.toLowerCase().contains("mobile"))
		 {
			 form.setName("WE Mobile Recharge");
			 return new WeMobileRecharge(form,c);
		 }
	            
	      else if(type.toLowerCase().contains("internet"))
	      {
	    	  form.setName("WE Internet");
	    	  return new WeInternetPayment(form,c);
	      }
		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
