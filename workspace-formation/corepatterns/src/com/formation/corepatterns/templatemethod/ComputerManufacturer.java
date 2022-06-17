package com.formation.corepatterns.templatemethod;

public abstract class ComputerManufacturer {

	public void buildComputer() {
		String disk = addHardDisk();
		String ram = addRam(disk);
		System.out.println(ram);
		String computer = addKeyboard();
		System.out.println(computer);

	}

	public abstract String addHardDisk();

	public abstract String addRam(String disk);

	public abstract String addKeyboard();
}
