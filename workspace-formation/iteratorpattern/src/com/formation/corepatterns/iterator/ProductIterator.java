package com.formation.corepatterns.iterator;

public class ProductIterator implements Iterator {

	Product[] products;
	int pos = 0;

	public ProductIterator(Product[] products) {
		this.products = products;
	}

	public boolean hasNext() {
		if (pos >= products.length || products[pos] == null) {
			return false;
		} else {
			return true;
		}
	}

	public Object next() {
		return products[pos++];
	}

}
