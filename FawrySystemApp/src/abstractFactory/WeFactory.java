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
			 //form.view();
			 return new WeMobileRecharge(form,mobileRechargeCommand);
		 }
	            
	      else if(type.toLowerCase().contains("internet"))
	      {
	    	  form.setName("WE Internet");
	    	  return new WeInternetPayment(form,internetCommand);
	      }
		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
