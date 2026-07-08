package com.internship.week1.day4;

import java.util.Scanner;
import java.util.Random;

public class WhileLoop {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Print numbers from 1 to 15 using a while loop.");
		int i = 1;
		while (i <= 15) {
			System.out.print(i++ + ", ");
		}

		System.out.println("\nPrint even numbers from 2 to 20.");
		i = 0;
		while (i < 20) {
			i += 2;
			System.out.print(i + ", ");
		}
		System.out.println("Checking the value of i: " + i);

		i = 20;
		System.out.println("\nPrint numbers from 20 down to 1.");
		while (i >= 1) {
			System.out.print(i-- + ", ");
		}

		System.out.print("\nEnter a number: ");
		int n = sc.nextInt();
		int sum = 0;
		i = 1;
		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println("Sum of numbers from 1 to " + n + " is " + sum);

		System.out.print("Enter a number: ");
                n = sc.nextInt();
		sum = 0;
		while (n >= 1) {
			sum++;
			n /= 10;
		}
		System.out.println("The total digits in the given number is " + sum);

		System.out.print("Enter a number: ");
                n = sc.nextInt();
                sum = 0;
                while (n >= 1) {
			if (n < 10) sum += n;
			else sum = (sum + (n % 10)) * 10;
			n /= 10;
                }

                System.out.println("The reverse of the given number is " + sum);


		System.out.println("***************  Coding Challenge **************");

		Random random = new Random();
		int secretNumber = random.nextInt(10);

		System.out.print("Try to guess the Secret number: ");
		int guess = sc.nextInt();
		while (guess != secretNumber) {
			System.out.print("Try Again: ");
			guess = sc.nextInt();
		}
		System.out.println("Correct! You guessed the number.");
	}
}
