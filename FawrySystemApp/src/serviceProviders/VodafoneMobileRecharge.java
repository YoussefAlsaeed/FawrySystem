package serviceProviders;

import command.Command;
import composite.Form;

public class VodafoneMobileRecharge implements IMobileRecharge{

//	@Override
//	public void pay() {
//		// TODO Auto-generated method stub
//		System.out.println("I am vodafonerecharge");
//	}
	

	Form form;
	Command c;

	public VodafoneMobileRecharge(Form form, Command c) {
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
