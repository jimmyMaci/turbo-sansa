package com.payment.module.api;

public interface CreditCardPayment extends Payment {
	String getName();
	void setName(String name);
	
	String getCard();
	void setCard(String card);
	
	String getCcv();
	void setCcv(String ccv);

}
