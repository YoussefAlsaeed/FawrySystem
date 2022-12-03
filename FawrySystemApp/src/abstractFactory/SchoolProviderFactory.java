package abstractFactory;

import serviceProviders.EtisalatInternetPayment;
import serviceProviders.EtisalatMobileRecharge;
import serviceProviders.IService;
import serviceProviders.SchoolsDonations;

public class SchoolProviderFactory extends ProviderFactory{

	@Override
	public void setFormName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IService createServiceProvider(String type) {
		createForm();
		createCommand();
		
		 if(type.toLowerCase().contains("donation"))
		 {
			 form.setName("School Donation ");
			 return new SchoolsDonations(form,c);
		 }
	            
	    
	        	  
		return null;
	}

}
