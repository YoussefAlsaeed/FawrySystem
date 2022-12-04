package PaymentMethodStrategy;

import mainPackage.*;

public class WalletPaymentMethod implements IPaymentMethod {

	@Override
	public void pay(User user,double amount) {
		if(user.getWallet()<amount)
		{
			System.out.println("Not Enough balance in your wallet, please add money to your wallet");
		}
		else user.setWallet(user.getWallet()-amount);
		

	}
	public String toString()
	{
		return "Payment method = Wallet";
		
	}
}
