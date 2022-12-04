package serviceProviders;

import command.Command;
import command.LandlineCommand;
import composite.Form;

public class MonthlyReciept extends LandLine {

	public MonthlyReciept(Form form, LandlineCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Monthly Reciept Landline";
	}

}
