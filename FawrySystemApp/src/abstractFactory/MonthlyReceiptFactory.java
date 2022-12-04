package abstractFactory;

import serviceProviders.EtisalatInternetPayment;
import serviceProviders.EtisalatMobileRecharge;
import serviceProviders.IService;
import serviceProviders.MonthlyReciept;

public class MonthlyReceiptFactory extends ProviderFactory{

	@Override
	public void setFormName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IService createServiceProvider(String type) {
	
		 if(type.toLowerCase().contains("landline"))
		 {
			 form.setName("Monthly Receipt Landline");
			 return new MonthlyReciept(form,landlineCommand);
		 }
	         
	        	  
		return null;
	}

}
