package serviceProviders;

import command.Command;
import command.MobileRechargeCommand;
import composite.Form;

public class EtisalatMobileRecharge extends MobileRechargeService {
	

	public EtisalatMobileRecharge(Form form, MobileRechargeCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Etisalat Mobile Recharge";
	}

}