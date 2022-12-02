package command;
import java.util.ArrayList;

import PaymentMethodStrategy.*;
import composite.*;
import mainPackage.*;
public class SubmitCommand extends Command {
	Form form;
	IPaymentMethod payment;
	@Override
	public void execute(Form form,User user) {
		form.view();
		ArrayList<String> values=new ArrayList<String>();
		values=form.getValues();
		//System.out.println(values.get(0));
		if(values.get(0).equals("c"))
		{
			payment=new CreditCardPaymentMethod();
			double amount=Double.parseDouble(values.get(1));
			//System.out.println("sdshf"+amount);
			payment.pay(user, amount);
			System.out.println(user.getCreditCard());
		}
		else if(values.get(0).equals("w"))
		{
			payment=new WalletPaymentMethod();
			double amount=Double.parseDouble(values.get(1));
			//System.out.println("sdshf"+amount);
			payment.pay(user, amount);
			System.out.println(user.getWallet());
		}
		
		
	}

}
