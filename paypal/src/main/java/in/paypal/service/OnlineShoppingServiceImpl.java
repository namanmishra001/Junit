package in.paypal.service;

import in.paypal.dto.TransactionDetails;

public class OnlineShoppingServiceImpl implements OnlineShoppingService {

	private PayPalService palService;

	public void setService(PayPalService service) {
		this.palService = service;
	}

	public String payment(int card, float amount) {
		boolean verificationStatus = palService.verifyCardNumber(card);
		if (verificationStatus) {
			TransactionDetails payment = palService.doPayment(card, amount);
			return "payment done for" + card + "for Amount" + amount + "using CardType" + payment.getCardType();
		} else {
			return "invalid Card Number";
		}
	}

}
