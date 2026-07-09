package com.internship.week1.day5;

public class Arrays {

	public static void main(String args[]) {

		int[] marks = {78, 95, 80, 66, 92};

		System.out.println("First mark:  " + marks[0]);
                System.out.println("Last mark:   " + marks[marks.length - 1]);
                System.out.println("Total marks: " + marks.length);



		for (int i = 0; i < marks.length; i++) {
			System.out.print(marks[i] + " ");
		}

		for (int i = marks.length - 1; i >= 0; i--) {
			System.out.print(marks[i] + " ");
		}

		for (int i = 0; i < marks.length; i++) {
			System.out.print(marks[i] % 2 == 0 ? marks[i] + " " : "");
		}


		String[] names = {"Fawad", "Siraj", "Bilal", "Hammad", "Kamran"};
		for (int i = 0; i < names.length; i++) {
			System.out.println("Student " + i + ": " + names[i]);
		}
	}
}
