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
			 //mobileRechargeCommand.setForm(form);
			 return new WeMobileRecharge(form,mobileRechargeCommand);
		 }
	            
	      else if(type.toLowerCase().contains("internet"))
	      {
	    	  form.setName("WE Internet");
	    	  //internetCommand.setForm(form);
	    	  return new WeInternetPayment(form,internetCommand);
	      }
		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
