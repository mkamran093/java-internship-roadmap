package com.internship.week1.day2;

import java.util.Scanner;

public class Login {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter username: ");
		String username = sc.nextLine();

		if ("admin".equals(username)) {
			System.out.println("Welcome Admin");
		}

	}
}
