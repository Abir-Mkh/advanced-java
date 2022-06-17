package com.formation.corepatterns.templatemethod;

public class TestComputer {

	public static void main(String[] args) {

		ComputerManufacturer computer = new LaptopManufacturer();
		computer.buildComputer();
	}

}
