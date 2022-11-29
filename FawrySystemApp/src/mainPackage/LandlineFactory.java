package mainPackage;

public class LandlineFactory implements IServiceFactory {

	@Override
	public IService createService() {
		return new LandlineService();
	}

}
