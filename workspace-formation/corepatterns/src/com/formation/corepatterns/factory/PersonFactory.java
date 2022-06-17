package com.formation.corepatterns.factory;

public class PersonFactory {

	public static Person createPerson(String msg) {
		Person person = null;

		if (msg.equals("male")) {
			person = new Male();
		} else if (msg.equals("female")) {
			person = new Female();
		}

		return person;

	}

}
