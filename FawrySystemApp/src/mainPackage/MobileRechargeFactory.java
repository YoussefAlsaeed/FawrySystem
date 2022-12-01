package mainPackage;

public class MobileRechargeFactory implements IServiceFactory {

    @Override
    public IService createService(String Type) {
        // TODO Auto-generated method stub
        //Type=Type.trim();
    
        if(Type.toLowerCase().contains("vodafone"))
            return new VodafoneMobileRecharge();
        else if(Type.toLowerCase().contains("Etisalat"))
            return new EtisalatMobileRecharge();
        else if(Type.toLowerCase().contains("We"))
            return new WeMobileRecharge();
        else if(Type.toLowerCase().contains("Orange"))
            return new OrangeMobileRecharge();
        
        return null;
        
        
    }

}