package com.internship.week1.day5;

public class Strings {

	public static void main(String args[]) {

		String name = "Muhammad Kamran";
		System.out.println("Name: " + name);
		System.out.println("Uppercase name: " + name.toUpperCase());
		System.out.println("Name: " + name);

		String username = "   Ali Khan   ";
		System.out.println("Original username: '" + username + "'");
		System.out.println("Trimmed version: " + username.trim());
		System.out.println("Uppercase version: " + username.toUpperCase());
		System.out.println("Original again(did not changed): '" + username + "'");

		String text = "   Java Programming Language   ";
		System.out.println("Original String : '" + text + "'");
		System.out.println("Trimmed version : " + text.trim());
		System.out.println("Trimmed length  : " + text.trim().length());
		System.out.println("First character : " + text.trim().charAt(0));
		System.out.println("Last character  : " + text.trim().charAt(text.trim().length() - 1));
		System.out.println("Extract middle  : " + text.substring(7, 19));
		System.out.println("Contains Java   : " + text.contains("Java"));
		System.out.println("Contains Python : " + text.contains("Python"));
	}
}
