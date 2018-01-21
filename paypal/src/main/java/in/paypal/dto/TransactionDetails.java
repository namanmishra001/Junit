package in.paypal.dto;

import java.util.Date;

public class TransactionDetails {

	private int cardNumber;
	private String cardType;
	private float amount;
	private Date txDate;

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	@Override
	public String toString() {
		return "TransactionDetails [cardNumber=" + cardNumber + ", cardType=" + cardType + ", amount=" + amount
				+ ", txDate=" + txDate + "]";
	}

}
