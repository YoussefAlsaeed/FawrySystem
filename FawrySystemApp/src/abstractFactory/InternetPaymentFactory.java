package abstractFactory;

import serviceProviders.*;

public class InternetPaymentFactory implements IServiceFactory {

    @Override
    public IService createService(String Type) {
        
        if(Type.toLowerCase().contains("vodafone"))
            return new VodafoneInternetPayment();
        else if(Type.toLowerCase().contains("Etisalat"))
            return new EtisalatInternetPayment();
        else if(Type.toLowerCase().contains("We"))
            return new WeInternetPayment();
        else if(Type.toLowerCase().contains("Orange"))
            return new OrangeInternetPayment();
    
        return null;
    }

}
