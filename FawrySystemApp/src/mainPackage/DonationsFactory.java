package mainPackage;

public class DonationsFactory implements IServiceFactory {

	@Override
	public IService createService() {		
		return new DonationsService();
	}
	

}
