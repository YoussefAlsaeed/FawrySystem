package refundRequestStrategy;

import mainPackage.User;
import transaction.ITransaction;

public interface IRefundRequest {
public void refund(ITransaction acceptedTransaction,User user);
}
