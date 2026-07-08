package com.internship.week1.day4;

import java.util.Scanner;

public class Continue {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a sentence: ");
		String text = sc.nextLine();
		int vowelCount = 0;
		String vowels = "aeiouAEIOU";
		char[] characters = text.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			if (vowels.indexOf(characters[i]) != -1) vowelCount++;

		}

		System.out.println("Total vowels in this text: " + vowelCount);
	}
}
