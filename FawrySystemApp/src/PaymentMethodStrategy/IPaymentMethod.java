package PaymentMethodStrategy;

import mainPackage.User;

public interface IPaymentMethod {	

	boolean pay(User user, double amount);
	String toString();
}
