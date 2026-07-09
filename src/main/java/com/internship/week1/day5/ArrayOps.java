package com.internship.week1.day5;

public class ArrayOps {

	public static void main(String args[]) {

		int[] arr = {3, 63, 95, 39, 60, 40, 69, 84, 28, 50};

		int max = arr[0], min = arr[0], sum = 0, count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) max = arr[i];
			if (arr[i] < min) min = arr[i];
			sum += arr[i];
			if (arr[i] % 2 == 0) count++;
		}

		double average = (double)sum/arr.length;

		System.out.println("Minimum number in array: " + min);
		System.out.println("Maximum number in array: " + max);
		System.out.println("Sum of all the numbers:  " + sum);
		System.out.println("Average of all numbers:  " + average);
		System.out.println("Total even numbers :     " + count);
	}
}
