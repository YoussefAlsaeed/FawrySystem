package serviceProviders;

import command.Command;
import composite.Form;

public class WeMobileRecharge implements IMobileRecharge {

	Form form;
	Command c;

	public WeMobileRecharge(Form form, Command c) {
		this.form=form;
		this.c=c;
		form.view();
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
