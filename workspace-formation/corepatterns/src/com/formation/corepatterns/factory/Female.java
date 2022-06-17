package com.formation.corepatterns.factory;

public class Female implements Person {

	@Override
	public void wish(String msg) {
		msg = "Female";
		System.out.println(msg);
	}

}
