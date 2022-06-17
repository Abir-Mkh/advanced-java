package com.formation.corepatterns.templatemethod;

public class DesktopManufacturer extends ComputerManufacturer {

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

		String computer = "Desktop";
		return "Keyboard Added to " + computer;
	}

}
