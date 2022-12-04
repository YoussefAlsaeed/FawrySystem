package abstractFactory;

import serviceProviders.IService;

import java.util.ArrayList;

import command.*;
import composite.*;
import serviceProviders.*;

public class EtisalatFactory extends ProviderFactory  {

//	Form form;
//	Command c;
//	//ArrayList<UIElements> elements = new ArrayList<UIElements>();
	@Override
	public IService createServiceProvider(String type) {
	
		 if(type.toLowerCase().contains("mobile"))
		 {
			 form.setName("Etisalat Mobile Recharge");
			 //mobileRechargeCommand.setForm(form);
			 return new EtisalatMobileRecharge(form,mobileRechargeCommand);
		 }
	            
	      else if(type.toLowerCase().contains("internet"))
	      {
	    	  form.setName("Etisalat Internet");
	    	  //internetCommand.setForm(form);
	    	  return new EtisalatInternetPayment(form,internetCommand);
	      }
	        	  
		return null;
	}
	@Override
	public void setFormName(String name) {
		
		
	}

}
