package refundRequestStrategy;

import mainPackage.User;
import transaction.ITransaction;

public class WalletPaymentRefundRequest implements IRefundRequest {

	@Override
	public void refund(ITransaction acceptedTransaction, User user) {
		// TODO Auto-generated method stub
		user.setWallet(user.getWallet()+acceptedTransaction.getAmount());
		
	}

}
