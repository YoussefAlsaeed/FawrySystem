package refundRequestStrategy;

import mainPackage.User;
import transaction.ITransaction;

public class PaymentRefundRequest implements IRefundRequest {
	@Override
	public void refund(ITransaction acceptedTransaction,User user) {
	
		user.setCreditCard(user.getCreditCard()+acceptedTransaction.getAmount());

}
}