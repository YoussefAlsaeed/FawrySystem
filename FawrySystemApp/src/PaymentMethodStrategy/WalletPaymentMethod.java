package PaymentMethodStrategy;

import mainPackage.*;

public class WalletPaymentMethod implements IPaymentMethod {

	@Override
	public void pay(User user,double amount) {
		if(user.getWallet()<amount)
		{
			System.out.println("Not Enough in ur wallet");
		}
		else user.setWallet(user.getWallet()-amount);
		

	}
}
