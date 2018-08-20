package com.dillip.practice.solutions;

import com.dillip.practice.BaseStructure;

public class ConvertDecimalToBinary extends BaseStructure {
	int number = 0;
	StringBuilder builder = new StringBuilder();
	String binary;

	@Override
	public void prepareInput() {
		number = 123897;
	}

	@Override
	public void execute() {

		prepareInput();
		System.out.println("Started Decimal to Binary  Convertion");
		System.out.print("Binary of : " + number + " is : ");
		convertDecimaltoBinary(number);
		binary = builder.toString();
		System.out.println();
		System.out.print(binary);
		System.out.println();
		System.out.println("Decimal to Binary  Convertion Ended");

		System.out.println("Started Binary to Decimal Convertion");
		convertBinarytoDecimal(binary);
		System.out.println();
		System.out.println("Binary to Decimal Convertion Ended");

	}

	private void convertDecimaltoBinary(int number) {
		while (number > 0) {
			System.out.print(number % 2);
			builder.append(number % 2+"");
			number = number / 2;

		}
	}

	private void convertBinarytoDecimal(String binary) {
		long number = 0;
		int j = 0;
		System.out.print("Decimal of : " + binary + " is : ");
		for (int i = binary.length() - 1; i >= 0; i--) {
			System.out.print("( " + binary.charAt(i) + "*" + Math.abs(Math.pow(2, j)) + ")+");
			number += (long) (binary.charAt(i) * Math.abs(Math.pow(2, j)));
			j++;
		}
		System.out.print("Decimal of : " + binary + " is : " + number);

	}
}
