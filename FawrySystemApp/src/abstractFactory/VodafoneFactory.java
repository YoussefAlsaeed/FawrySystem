package abstractFactory;

import serviceProviders.IService;

import java.util.ArrayList;

import command.*;
import composite.*;
import serviceProviders.*;

public class VodafoneFactory extends ProviderFactory  {

//	Form form;
//	Command c;
//	//ArrayList<UIElements> elements = new ArrayList<UIElements>();
	@Override
	public IService createServiceProvider(String type) {
		
		
		 if(type.toLowerCase().contains("mobile"))
		 {
			 form.setName("Vodafone Mobile Recharge");
			 return new VodafoneMobileRecharge(form,mobileRechargeCommand);
		 }
	            
	      else if(type.toLowerCase().contains("internet"))
	      {
	    	  form.setName("Vodafone Internet");
	    	  return new VodafoneInternetPayment(form,internetCommand);
	      }
		 
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
