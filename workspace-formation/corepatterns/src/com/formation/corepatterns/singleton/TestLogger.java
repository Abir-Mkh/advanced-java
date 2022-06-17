package com.formation.corepatterns.singleton;

public class TestLogger {

	public static void main(String[] args) {

		Logger logger1 = Logger.log("log1");
		Logger logger2 = Logger.log("log2");

		System.out.println(logger1 == logger2);
	}

}
