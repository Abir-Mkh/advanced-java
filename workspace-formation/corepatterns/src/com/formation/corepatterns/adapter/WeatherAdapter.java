package com.formation.corepatterns.adapter;

public class WeatherAdapter {

	public int findTemperature(int zipcode) {
		String city = null;
		if (zipcode == 19406) {
			city = "King Of Prussia";
		}

		WeatherFinder finder = new WeatherFinderImpl();
		int temperature = finder.find(city);

		return temperature;

	}

}
