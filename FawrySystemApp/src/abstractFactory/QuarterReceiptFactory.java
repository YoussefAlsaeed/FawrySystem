package abstractFactory;

import serviceProviders.EtisalatInternetPayment;
import serviceProviders.EtisalatMobileRecharge;
import serviceProviders.IService;
import serviceProviders.QuarterReceipt;

public class QuarterReceiptFactory extends ProviderFactory{

	/*
	 * Creating new service providers of type (we)
	 * Each service provider takes form and command in its parameter
	 * Command type is set according to the service that the user wants
	 */
	@Override
	public void setFormName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IService createServiceProvider(String type) {
		
		 if(type.toLowerCase().contains("landline"))
		 {
			 form.setName("Quarter Receipt Landline");
			 //landlineCommand.setForm(form);
			 return new QuarterReceipt(form,landlineCommand);
		 }
	            
	      
		 
	        	  
		return null;
	}

}
