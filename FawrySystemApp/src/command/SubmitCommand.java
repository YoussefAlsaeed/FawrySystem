package command;
import java.util.ArrayList;

import PaymentMethodStrategy.*;
import composite.*;
import mainPackage.*;
public class SubmitCommand extends Command {
	Form form;
	IPaymentMethod payment;
	public SubmitCommand(User user, Form form) {
		this.form=form;
		this.user=user;
	}
	public SubmitCommand(User user) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() {
		form.view();
		ArrayList<String> values=new ArrayList<String>();
		values=form.getValues();
		//System.out.println(values.get(0));
		if(values.get(0).equals("1"))
		{
			payment=new CreditCardPaymentMethod();
			double amount=Double.parseDouble(values.get(1));
			
			payment.pay(user, amount);
			System.out.println(user.getCreditCard());
		}
		else if(values.get(0).equals("2"))
		{
			payment=new WalletPaymentMethod();
			double amount=Double.parseDouble(values.get(1));
			
			payment.pay(user, amount);
			System.out.println(user.getWallet());
		}
		else if(values.get(0).equals("3"))
		{
			payment=new CashOnDeliveryMethod();
			double amount=Double.parseDouble(values.get(1));
		}
		else System.out.println("Payment Method not found");
		
		
	}
	
	//setters and getters
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public IPaymentMethod getPayment() {
		return payment;
	}
	public void setPayment(IPaymentMethod payment) {
		this.payment = payment;
	}


}
