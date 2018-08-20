package com.dillip.practice.solutions;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseStringInPlace {

	public static void reverse(char[] arrayOfChars) {

		// reverse input array of characters in place
		int length=arrayOfChars.length;
		for (int i = 0; i < length / 2; i++) {
			// even array odd array
			char temp = arrayOfChars[i];
//			System.out.println("Before Operation : "+i+"th time ");
//			System.out.print(arrayOfChars);
			arrayOfChars[i] = arrayOfChars[length - (i+1)];
			arrayOfChars[length - (i+1)] = temp;
//			System.out.println("After Operation : "+i+"th time ");
//			System.out.print(arrayOfChars);
		}

	}

	// tests

	@Test
	public void emptyStringTest() {
		final char[] expected = "".toCharArray();
		final char[] actual = "".toCharArray();
		reverse(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void singleCharacterStringTest() {
		final char[] expected = "A".toCharArray();
		final char[] actual = "A".toCharArray();
		reverse(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void longerStringTest() {
		final char[] expected = "EDCBA".toCharArray();
		final char[] actual = "ABCDE".toCharArray();
		reverse(actual);
		assertArrayEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ReverseStringInPlace.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}