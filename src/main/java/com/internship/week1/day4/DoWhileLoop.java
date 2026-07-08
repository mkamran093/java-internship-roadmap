package com.internship.week1.day4;

import java.util.Scanner;

public class DoWhileLoop {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Print numbers from 1 to 10 using a do-while loop.");
		int i = 0;
		do {
			System.out.print(++i + ", ");
		} while(i < 10);

		System.out.println("\nPrint even numbers from 2 to 20.");
		i = 2;
		do {
			System.out.print(i + ", ");
			i += 2;
		} while(i <= 20);

		i = 10;
		System.out.println("\nPrint numbers from 10 down to 1.");
		do {
			System.out.print(i-- + ", ");
		} while (i >= 1);


		do {
			System.out.print("Please enter a positive number: ");
			i = sc.nextInt();
		} while(i < 0);

		System.out.println("That is a very good positive number.");

		char option;
		do {
			System.out.println("Hello");
			System.out.print("Do you want to continue(y/n)? ");
			option = sc.next().charAt(0);
		} while(option == 'y' || option == 'Y');

		do {
			System.out.println("1 - Addition");
			System.out.println("2 - Subtraction");
			System.out.println("3 - Exit");

			System.out.print("Enter an option: ");
			option = sc.next().charAt(0);
		} while(option != '3');

		int choice, a, b;
		do {
                        System.out.println("1. Add");
                        System.out.println("2. Subtract");
                        System.out.println("3. Multiply");
                        System.out.println("4. Divide");
                        System.out.println("5. Exit");

			System.out.print("Select an operation: ");
			choice = sc.nextInt();

			System.out.print("Enter first operand: ");
			a = sc.nextInt();
			System.out.print("Enter second operand: ");
			b = sc.nextInt();

			if (choice == 1) System.out.println(a + b);
			else if (choice == 2) System.out.println(a - b);
			else if (choice == 3) System.out.println(a * b);
			else if (choice == 4) System.out.println(a / b);
		} while (choice != 5);

	}
}
