package com.formation.corepatterns.flyweight;

public class Rectangle extends Shape {

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Rectangle() {
		label = "Rectangle";
	}

	@Override
	public void draw(int length, int breadth, String fillStyle) {
		System.out.println(
				"Drawning a " + label + " with Lengh " + length + " Breadth " + breadth + " Fill Style " + fillStyle);

	}

}
