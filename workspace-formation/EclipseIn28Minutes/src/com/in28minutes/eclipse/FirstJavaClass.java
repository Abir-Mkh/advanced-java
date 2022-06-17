package com.in28minutes.eclipse;

public class FirstJavaClass {

	class Bean {
		private int var1;
		private int var2;

		public int getVar1() {
			return var1;
		}

		public void setVar1(int var1) {
			this.var1 = var1;
		}

		public int getVar2() {
			return var2;
		}

		public void setVar2(int var2) {
			this.var2 = var2;
		}

		public Bean(int var1, int var2) {
			super();
			this.var1 = var1;
			this.var2 = var2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + var1;
			result = prime * result + var2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Bean other = (Bean) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (var1 != other.var1) {
				return false;
			}
			if (var2 != other.var2) {
				return false;
			}
			return true;
		}

		private FirstJavaClass getOuterType() {
			return FirstJavaClass.this;
		}

	}

	private static final double PI = 3.14;

	interface Dummy {

	}

	class DummyClass implements Dummy {

	}

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };

		int sum = calculateSumForNNumber(numbers);

		int radius = 5;
		double area = PI * radius * radius;
		System.out.println("Area is" + area);

		System.out.println(sum);
		System.out.println();
	}

	private static int calculateSumForNNumber(int[] numbers) {
		int result = 0;
		for (int number : numbers) {
			result += number;
		}
		return result;
	}

}
