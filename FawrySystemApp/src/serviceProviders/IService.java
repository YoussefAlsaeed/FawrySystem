package serviceProviders;

import java.util.ArrayList;

import mainPackage.*;

public interface IService {
	public boolean fillForm(User user);
	public void pay(User user,ArrayList<String> values);
	
}
