package serviceProviders;

import command.Command;
import command.MobileRechargeCommand;
import composite.Form;

public class OrangeMobileRecharge extends MobileRechargeService {


	public OrangeMobileRecharge(Form form, MobileRechargeCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Orange Mobile Recharge";
	}

}
