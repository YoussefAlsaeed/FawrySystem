package serviceProviders;

import command.Command;
import composite.Form;

public class OrangeMobileRecharge implements IMobileRecharge {

//	@Override
//	public void pay() {
//		// TODO Auto-generated method stub
//		System.out.println("I am orange recharge");
//	}
	
	Form form;
	Command c;

	public OrangeMobileRecharge(Form form, Command c) {
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
