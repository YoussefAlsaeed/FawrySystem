package mainPackage;

public class InternetPaymentFactory implements IServiceFactory {

	@Override
	public IService createService() {
		
		return new InternetPaymentService();
	}

}
