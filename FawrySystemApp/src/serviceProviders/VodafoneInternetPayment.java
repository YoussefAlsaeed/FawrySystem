package serviceProviders;

import command.Command;
import command.InternetCommand;
import composite.Form;
import mainPackage.User;

public class VodafoneInternetPayment extends InternetPayment{


	public VodafoneInternetPayment(Form form, InternetCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Vodafone Internet Payment";
	}


}
