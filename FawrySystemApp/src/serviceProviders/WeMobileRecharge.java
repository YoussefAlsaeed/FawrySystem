package serviceProviders;

import command.Command;
import composite.Form;

public class WeMobileRecharge extends MobileRechargeService {

	public WeMobileRecharge(Form form, Command c) {
		super(form, c);
	
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCost(double n) {
		// TODO Auto-generated method stub
		
	}

}
