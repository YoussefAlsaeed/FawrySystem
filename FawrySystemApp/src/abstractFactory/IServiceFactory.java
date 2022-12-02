package abstractFactory;

import serviceProviders.*;

public interface IServiceFactory {
public IService createService(String Type);
   
   	
   	/*public IMobileRecharge createMobileRechargeService()
    {
		return null;}
	public IInternetPayment createInternetPaymentService() {
		return null;}
	public IDonations createDonationsService(){
		return null;}
	*/
}
