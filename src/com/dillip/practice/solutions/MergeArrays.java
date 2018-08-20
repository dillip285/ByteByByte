package com.dillip.practice.solutions;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MergeArrays {

	public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

		// combine the sorted arrays into one large sorted array
		if (myArray.length == 0 || alicesArray.length == 0) {
			return myArray.length > alicesArray.length ? myArray : alicesArray;
		}
		int firstIndex = 0;
		int secondIndex = 0;
		int resultIndex = 0;
		int result[] = new int[myArray.length + alicesArray.length];
		while (firstIndex < myArray.length || secondIndex < alicesArray.length) {
			if (firstIndex < myArray.length && secondIndex < alicesArray.length) {
				if (myArray[firstIndex] < alicesArray[secondIndex]) {
					result[resultIndex] = myArray[firstIndex];
					resultIndex++;
					firstIndex++;
				} else {
					result[resultIndex] = alicesArray[secondIndex];
					resultIndex++;
					secondIndex++;
				}
			} else {
				if (firstIndex < myArray.length) {
					result[resultIndex] = myArray[firstIndex];
					resultIndex++;
					firstIndex++;
				} else {
					result[resultIndex] = alicesArray[secondIndex];
					resultIndex++;
					secondIndex++;
				}
			}
		}

		return result;
	}

	// tests

	@Test
	public void bothArraysAreEmptyTest() {
		final int[] myArray = {};
		final int[] alicesArray = {};
		final int[] expected = {};
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void firstArrayIsEmptyTest() {
		final int[] myArray = {};
		final int[] alicesArray = { 1, 2, 3 };
		final int[] expected = { 1, 2, 3 };
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void secondArrayIsEmptyTest() {
		final int[] myArray = { 5, 6, 7 };
		final int[] alicesArray = {};
		final int[] expected = { 5, 6, 7 };
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void bothArraysHaveSomeNumbersTest() {
		final int[] myArray = { 2, 4, 6 };
		final int[] alicesArray = { 1, 3, 7 };
		final int[] expected = { 1, 2, 3, 4, 6, 7 };
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void arraysAreDifferentLengthsTest() {
		final int[] myArray = { 2, 4, 6, 8 };
		final int[] alicesArray = { 1, 7 };
		final int[] expected = { 1, 2, 4, 6, 7, 8 };
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MergeArrays.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}