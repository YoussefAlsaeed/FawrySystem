package abstractFactory;

import serviceProviders.EtisalatInternetPayment;
import serviceProviders.EtisalatMobileRecharge;
import serviceProviders.IService;
import serviceProviders.SchoolsDonations;

public class SchoolProviderFactory extends ProviderFactory{

	/*
	 * Creating new service providers of type (we)
	 * Each service provider takes form and command in its parameter
	 * Command type is set according to the service that the user wants
	 */
	@Override
	public IService createServiceProvider(String type) {
	
		
		 if(type.toLowerCase().contains("donation"))
		 {
			 form.setName("School Donation ");
			// donationCommand.setForm(form);
			 return new SchoolsDonations(form,donationCommand);
		 }
	            
	    
	        	  
		return null;
	}

}
