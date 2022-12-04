package PaymentMethodStrategy;

import mainPackage.User;

public class CashOnDeliveryMethod implements IPaymentMethod{

	@Override
	public void pay(User user, double amount) {
		System.out.println(user.getUsername()+",The amount you are going to pay = "+amount);
		
	}
	public String toString()
	{
		return "Payment method = Cash On Delivery";
		
	}
	
}
