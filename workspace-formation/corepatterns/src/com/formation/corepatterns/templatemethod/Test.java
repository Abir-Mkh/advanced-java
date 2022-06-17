package com.formation.corepatterns.templatemethod;

public class Test {

	public static void main(String[] args) {

		DataRenderer renderer = new XMLDataRenderer();
		renderer.render();
	}

}
