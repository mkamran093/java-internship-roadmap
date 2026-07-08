package com.internship.week1.day2;

import java.util.Scanner;

public class Inputs {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

System.out.print("Age: ");
int age = input.nextInt();

input.nextLine();

System.out.print("Name: ");
String name = input.nextLine();

System.out.println(name);

	}
}
