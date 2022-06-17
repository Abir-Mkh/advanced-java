package com.formation.corepatterns.adapter;

public class PaymentAdapter {

	public int pay(int rupees) {

		int dollars = 0;

		if (rupees != 0) {
			dollars = rupees / 64;
		}

		PaymentProcessor p = new PaymentProcessorImpl();
		int payment = p.pay(dollars);

		return payment;

	}

}
