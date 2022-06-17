package com.formation.corepatterns.iterator;

public class Test {

	public static void main(String[] args) {

		ProductCollection products = new ProductCollection();
		products.addProduct(new Product("Iphone"));
		products.addProduct(new Product("Mac"));
		products.addProduct(new Product("Samsung"));

		Iterator iterator = products.createIterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			System.out.println(product.getName());
		}

	}

}
