package com.formation.corepatterns.singleton;

public class TestEnumSingleton {

	public static void main(String[] args) {
		EnumSingletonDemo instance = EnumSingletonDemo.INSTANCE;
		System.out.println(instance.getName());
		instance.setName("abir");
		System.out.println(instance.getName());
	}

}
