package PaymentMethodStrategy;

import mainPackage.*;

public class CreditCardPaymentMethod implements IPaymentMethod {

	@Override
	public void pay(User user,double amount) {
		
		user.CreditCard-=amount;

	}

}