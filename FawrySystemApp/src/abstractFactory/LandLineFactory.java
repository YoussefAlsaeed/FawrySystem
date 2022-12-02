package abstractFactory;

import serviceProviders.*;

public class LandLineFactory implements IServiceFactory {

    @Override
    public IService createService(String Type) {
        // TODO Auto-generated method stub 
        if(Type.toLowerCase().contains("monthly"))
            return new MonthlyReciept();
        else if(Type.contains("quarter"))
            return new QuarterReceipt();
        
        return null;
        
    }

}
