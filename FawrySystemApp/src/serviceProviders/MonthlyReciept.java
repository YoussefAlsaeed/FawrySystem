package serviceProviders;

import command.Command;
import composite.Form;

public class MonthlyReciept implements ILandLineProvider {

//	@Override
//	public void pay() {
//		// TODO Auto-generated method stub
//		System.out.println("monthly receipt");
//	}
	
	Form form;
	Command c;

	public MonthlyReciept(Form form, Command c) {
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
