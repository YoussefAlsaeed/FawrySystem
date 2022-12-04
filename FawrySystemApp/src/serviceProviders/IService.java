package serviceProviders;

import java.util.ArrayList;

import mainPackage.*;

public interface IService {
	double getCost();

	void setCost(double n);
	boolean pay(User user);
}
