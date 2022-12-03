package serviceProviders;

import command.Command;
import composite.Form;

public class CancerHospitalDonations implements IDonationsProvider {

	Form form;
	Command c;

	public CancerHospitalDonations(Form form, Command c) {
		this.form=form;
		this.c=c;
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