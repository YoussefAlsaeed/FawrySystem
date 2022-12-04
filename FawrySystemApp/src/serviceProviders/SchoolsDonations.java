package serviceProviders;

import command.Command;
import command.DonationsCommand;
import composite.Form;
import discountsDecorator.DonationsDiscount;

public class SchoolsDonations extends Donation{

	public SchoolsDonations(Form form, DonationsCommand c) {
		super(form, c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString()
	{
		return "Schools Donation";
	}



}
