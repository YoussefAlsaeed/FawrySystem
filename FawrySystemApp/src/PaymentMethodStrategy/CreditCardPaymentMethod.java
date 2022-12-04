package PaymentMethodStrategy;

import mainPackage.*;

public class CreditCardPaymentMethod implements IPaymentMethod {

	@Override
	public void pay(User user,double amount) {
		
		user.setCreditCard(user.getCreditCard()-amount);

	}
	public String toString()
	{
		return "Payment method = Credit card";
		
	}

}
