package abstractFactory;

import serviceProviders.IService;

import java.util.ArrayList;

import command.*;
import composite.*;
import serviceProviders.*;

public class OrangeFactory extends ProviderFactory  {

//	Form form;
//	Command c;
//	//ArrayList<UIElements> elements = new ArrayList<UIElements>();
	@Override
	public IService createServiceProvider(String type) {
		
		
		 if(type.toLowerCase().contains("mobile"))
		 {
			 form.setName("Orange Mobile Recharge");
			// mobileRechargeCommand.setForm(form);
			 return new OrangeMobileRecharge(form,mobileRechargeCommand);
		 }
	            
	      else if(type.toLowerCase().contains("internet"))
	      {
	    	  form.setName("Orange Internet");
	    	 // internetCommand.setForm(form);
	    	  return new OrangeInternetPayment(form,internetCommand);
	      }
		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
