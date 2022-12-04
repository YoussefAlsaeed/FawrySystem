package serviceProviders;

import command.Command;
import command.MobileRechargeCommand;
import composite.Form;

public class VodafoneMobileRecharge extends MobileRechargeService{
	

	public VodafoneMobileRecharge(Form form, MobileRechargeCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Vodafone Mobile Recharge";
	}


}
