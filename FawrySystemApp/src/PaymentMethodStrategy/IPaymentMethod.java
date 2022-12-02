package PaymentMethodStrategy;

import mainPackage.User;

public interface IPaymentMethod {	

	void pay(User user, double amount);
}
