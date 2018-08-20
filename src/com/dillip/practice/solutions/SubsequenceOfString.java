package com.dillip.practice.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class SubsequenceOfString {

	// tests
	private List<String> subsequenceOfString(String input) {
		ArrayList<String> result = new ArrayList<>();
		combination("", input, result);

		return result;
	}

	private void combination(String Output, String input, ArrayList<String> result) {
		if (input.length() == 0) {
			result.add(Output);
		} else {
			combination(Output + input.charAt(0), input.substring(1, input.length()),
						result);
			combination(Output, input.substring(1, input.length()),
					result);
			
		}
	}

	@Test
	public void findAllPermutationsOfString() {
		final String input = "Dilp";
		final List<String> actual = subsequenceOfString(input);
		System.out.println(actual);
		System.out.println("Count=" + actual.size());
		Set<String> unique = new HashSet<>();
		unique.addAll(actual);
		System.out.println("Unique count=" + unique.size());
		System.out.println(unique);
		// final List<String> expected = Arrays.asList(new Meeting(1, 4));
		// assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SubsequenceOfString.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}