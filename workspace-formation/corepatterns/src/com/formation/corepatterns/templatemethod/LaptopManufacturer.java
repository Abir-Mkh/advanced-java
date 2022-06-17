package com.formation.corepatterns.templatemethod;

public class LaptopManufacturer extends ComputerManufacturer {

	@Override
	public String addHardDisk() {

		return "Hard Disk";
	}

	@Override
	public String addRam(String disk) {

		return "Ram Added to " + disk;
	}

	@Override
	public String addKeyboard() {

		String computer = "Laptop";
		return "Keyboard Added to " + computer;
	}

}
