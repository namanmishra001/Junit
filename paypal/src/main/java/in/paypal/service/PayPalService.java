package in.paypal.service;

import in.paypal.dto.TransactionDetails;

public interface PayPalService {
	public boolean verifyCardNumber(int cardNo);
	public TransactionDetails doPayment(int cardNo,float amount);
}
