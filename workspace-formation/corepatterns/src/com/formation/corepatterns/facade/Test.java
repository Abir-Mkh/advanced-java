package com.formation.corepatterns.facade;

public class Test {

	public static void main(String[] args) {
		OrderFacade facade = new OrderFacade();
		facade.processOrder("MakBook", 3);

	}
}
