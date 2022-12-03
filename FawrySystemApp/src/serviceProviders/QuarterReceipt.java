package serviceProviders;

import command.Command;
import composite.Form;

public class QuarterReceipt implements ILandLineProvider {

//	@Override
//	public void pay() {
//		// TODO Auto-generated method stub
//		System.out.println("Quarter receipt");
//	}
	
	Form form;
	Command c;

	public QuarterReceipt(Form form, Command c) {
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
