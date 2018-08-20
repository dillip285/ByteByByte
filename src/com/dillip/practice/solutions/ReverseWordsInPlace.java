package com.dillip.practice.solutions;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseWordsInPlace {

	public static void reverseWords(char[] message) {

		// decode the message by reversing the words
		int start = 0;
		reverse(message, 0, message.length);
		for (int i = 0; i < message.length; i++) {
			if (message[i] == ' ' || i == message.length - 1) {

				System.out.println(message);
				reverse(message, start, i == message.length - 1 ? i + 1 : i);
				System.out.println(message);
				start = i + 1;
			}
		}

	}

	private static void reverse(char[] arrayOfChars, int start, int end) {

		// reverse input array of characters in place
		int length = end - 1;
		while (start < length) {
			// even array odd array
			char temp = arrayOfChars[start];
			// System.out.print("Before Operation : "+i+"th time ");
			//System.out.println(arrayOfChars);
			arrayOfChars[start] = arrayOfChars[length];
			arrayOfChars[length] = temp;
			start++;
			length--;
			// System.out.print("After Operation : "+i+"th time ");
			//System.out.println(arrayOfChars);
		}

	}

	// tests

	@Test
	public void oneWordTest() {
		final char[] expected = "vault".toCharArray();
		final char[] actual = "vault".toCharArray();
		reverseWords(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoWordsTest() {
		final char[] expected = "cake thief".toCharArray();
		final char[] actual = "thief cake".toCharArray();
		reverseWords(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void threeWordsTest() {
		final char[] expected = "get another one".toCharArray();
		final char[] actual = "one another get".toCharArray();
		reverseWords(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void multipleWordsSameLengthTest() {
		final char[] expected = "the cat ate the rat".toCharArray();
		final char[] actual = "rat the ate cat the".toCharArray();
		reverseWords(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void multipleWordsDifferentLengthsTest() {
		final char[] expected = "chocolate bundt cake is yummy".toCharArray();
		final char[] actual = "yummy is cake bundt chocolate".toCharArray();
		reverseWords(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void emptyStringTest() {
		final char[] expected = "".toCharArray();
		final char[] actual = "".toCharArray();
		reverseWords(actual);
		assertArrayEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ReverseWordsInPlace.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}