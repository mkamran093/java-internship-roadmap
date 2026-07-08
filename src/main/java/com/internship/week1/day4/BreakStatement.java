package com.internship.week1.day4;

import java.util.Scanner;

public class BreakStatement {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		String password = "java123";
		String guess;

		while(true) {
			guess = sc.nextLine();
			if (guess.equals(password)) {
				System.out.println("Access Granted");
				break;
			}
			System.out.println("Incorrect Password");
		}
	}
}
