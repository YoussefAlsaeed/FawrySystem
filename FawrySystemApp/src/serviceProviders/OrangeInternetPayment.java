package serviceProviders;

import command.Command;
import command.InternetCommand;
import composite.Form;

public class OrangeInternetPayment extends InternetPayment {


	public OrangeInternetPayment(Form form, InternetCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Orange Internet Payment";
	}

}
