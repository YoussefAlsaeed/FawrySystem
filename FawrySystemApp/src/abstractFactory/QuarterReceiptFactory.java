package abstractFactory;

import serviceProviders.EtisalatInternetPayment;
import serviceProviders.EtisalatMobileRecharge;
import serviceProviders.IService;
import serviceProviders.QuarterReceipt;

public class QuarterReceiptFactory extends ProviderFactory{

	@Override
	public void setFormName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IService createServiceProvider(String type) {
		createForm();
		createCommand();
		
		 if(type.toLowerCase().contains("Landline"))
		 {
			 form.setName("Quarter Receipt Landline");
			 return new QuarterReceipt(form,c);
		 }
	            
	      
		 
	        	  
		return null;
	}

}
