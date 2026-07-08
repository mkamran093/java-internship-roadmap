package com.internship.week1.day4;

import java.util.Scanner;

public class ForLoops {

	public static void main(String args[]) {

		System.out.println("Print Numbers from 1 to 20");
		for (int i = 1; i <= 20; i++) {
			System.out.print(i + ", ");
		}

		System.out.println("\nPrint numbers from 20 to 1");
		for (int i = 20; i >= 1; i--) {
			System.out.print(i + ", ");
		}

		System.out.println("\nPrint all even numbers from 2 to 50");
		for (int i = 2; i <= 50; i += 2) {
			System.out.print(i + ", ");
		}

		System.out.println("\nPrint all odd numbers from 1 to 99");
		for (int i = 1; i <= 99; i+= 2) {
			System.out.print(i + ", ");
		}


		int sum = 0;
		System.out.println("\nSum of numbers from 1 to 100");
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("\nSum: " + sum);

		System.out.println("\nTable of 7");
		for (int i = 1; i <= 10; i++) {
			System.out.println("7 x " + i + " = " + (7*i));
		}

		System.out.println("\nPrint all numbers divisible by 3 between 1 and 100");
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) System.out.print(i + ", ");
		}

		System.out.println("\n\n\n\n");
		System.out.println("********** 	Coding Challenge *********");
		
		Scanner sc = new Scanner(System.in);
		sum = 0;
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			sum +=i;
		}
		System.out.println("The sum of numbers from 1 to " + n + " is " + sum);
	}
}

