package serviceProviders;

import java.util.ArrayList;

import mainPackage.*;
import transaction.ITransaction;
import transaction.PaymentTransaction;

public interface IService {
	//public boolean fillForm(User user);
	public ITransaction pay(User user);
	
}
