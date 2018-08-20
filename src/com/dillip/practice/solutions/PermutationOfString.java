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

public class PermutationOfString {

	// tests
	private List<String> permuteString(String input) {
		ArrayList<String> result = new ArrayList<>();
		permute("", input, result);

		return result;
	}

	private void permute(String prefix, String suffix, ArrayList<String> result) {
		if (suffix.length() == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permute(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()),
						result);
			}
		}
	}

	@Test
	public void findAllPermutationsOfString() {
		final String input = "Dillip";
		final List<String> actual = permuteString(input);
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
		Result result = JUnitCore.runClasses(PermutationOfString.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}