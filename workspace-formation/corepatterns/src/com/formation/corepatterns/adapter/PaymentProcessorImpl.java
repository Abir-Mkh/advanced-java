package com.formation.corepatterns.adapter;

public class PaymentProcessorImpl implements PaymentProcessor {

	@Override
	public int pay(int dollars) {

		return dollars;
	}

}
