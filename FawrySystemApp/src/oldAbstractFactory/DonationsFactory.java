//package oldAbstractFactory;
//
//import serviceProviders.*;
//public class DonationsFactory implements IServiceFactory {
//
//    @Override
//    public IService createService(String Type) {
//
//        if(Type.toLowerCase().contains("schools"))
//            return new SchoolsDonations();
//        else if(Type.toLowerCase().contains("ngos"))
//            return new NgosDonations();
//        else if(Type.toLowerCase().contains("cancer"))
//            return new CancerHospitalDonations();
//        
//        
//        return null;
//    }
//
//}
//
