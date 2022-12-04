package serviceProviders;

import command.Command;
import command.InternetCommand;
import composite.Form;

public class WeInternetPayment extends InternetPayment {

	public WeInternetPayment(Form form, InternetCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "WE Internet Payment";
	}

}
