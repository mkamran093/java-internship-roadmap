package com.internship.week1.day5;

public class MarksAnalyzer {

	public static void main(String args[]) {

		int[] numbers = {12, 45, 67, 23, 67, 89, 34};
		int max = numbers[0], secondLargest = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				secondLargest = max;
				max = numbers[i];
			} else if (numbers[i] > secondLargest) {
				secondLargest = numbers[i];
			}
		}
		if (max == secondLargest) {
			System.out.println("There is no Second Largest number.");
		} else {
			System.out.println("Second Largest number is " + secondLargest);
		}

		System.out.println("Shift Array to right by 1");
		int lastItem = numbers[numbers.length - 1];
		for (int i = numbers.length - 2; i >= 0; i--) {
			numbers[i + 1] = numbers[i];
		}
		numbers[0] = lastItem;
		for (int x : numbers) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
