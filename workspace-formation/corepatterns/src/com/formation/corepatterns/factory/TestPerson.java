package com.formation.corepatterns.factory;

public class TestPerson {

	public static void main(String[] args) {

		Client ps = new Client();
		ps.createNewPerson("female");
	}

}
