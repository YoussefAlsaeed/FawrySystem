package mainPackage;


import transaction.ITransaction;

public class AddToWalletRefundRequest implements IRefundRequest {
	
	@Override
	public void refund(ITransaction acceptedTransaction,User user) {
		// TODO Auto-generated method stub
		
		user.setCreditCard(user.getCreditCard()+acceptedTransaction.getAmount());
		user.setWallet(user.getWallet()-acceptedTransaction.getAmount());
	}

}
