package refundRequestStrategy;


import mainPackage.User;
import transaction.ITransaction;

public class AddToWalletRefundRequest implements IRefundRequest {
	
	@Override
	public void refund(ITransaction acceptedTransaction,User user) {
	
		user.setCreditCard(user.getCreditCard()+acceptedTransaction.getAmount());
		user.setWallet(user.getWallet()-acceptedTransaction.getAmount());
		System.out.println(acceptedTransaction.getAmount()+" was returned to the user ("+user.getUsername()+") credit card");
	
	
	}


		
	}


