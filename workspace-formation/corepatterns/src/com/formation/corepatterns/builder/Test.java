package com.formation.corepatterns.builder;

public class Test {

	public static void main(String[] args) {
		HttpClient client = new HttpClient.HttpClientBuilder().method("POST").url("testurl").body("{}")
				.secure("user", "password").build();
		System.out.println(client);
	}

}
