package com.formation.corepatterns.factory;

public class Male implements Person {

	@Override
	public void wish(String msg) {
		msg = "Male";
		System.out.println(msg);
	}

}
