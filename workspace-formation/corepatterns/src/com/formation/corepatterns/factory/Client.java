package com.formation.corepatterns.factory;

public class Client {

	public Person createNewPerson(String msg) {

		Person p = PersonFactory.createPerson(msg);
		p.wish(msg);

		return p;
	}
}
