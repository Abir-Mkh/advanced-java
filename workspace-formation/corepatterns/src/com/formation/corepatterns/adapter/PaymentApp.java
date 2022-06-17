package com.formation.corepatterns.adapter;

public class PaymentApp {

	public void pay(int rupees) {

		PaymentAdapter adapter = new PaymentAdapter();
		System.out.println(adapter.pay(rupees));
	}

	public static void main(String[] args) {
		PaymentApp pApp = new PaymentApp();
		pApp.pay(1280);

	}

}
