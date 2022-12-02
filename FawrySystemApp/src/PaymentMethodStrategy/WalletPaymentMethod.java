package PaymentMethodStrategy;

import mainPackage.*;

public class WalletPaymentMethod implements IPaymentMethod {

	@Override
	public void pay(User user,double amount) {
		if(user.wallet<amount)
		{
			System.out.println("Not Enough in ur wallet");
		}
		else user.wallet-=amount;
		

	}
}
