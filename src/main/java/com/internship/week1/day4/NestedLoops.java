package com.internship.week1.day4;

public class NestedLoops {

	public static void main(String args[]) {

		System.out.println("Print a rectangle of 4 rows and 6 columns using *.");
		int height = 4, width = 6;

		for (int row = 1; row <= height; row++) {
			for (int col = 1; col <= width; col++) {
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println("Print a square of size 5.");
		for (int row = 1; row <= 5; row++) {
                        for (int col = 1; col <= 5; col++) {
                                System.out.print("* ");
                        }
                        System.out.println();
                }

		for (int row = 1; row <= 5; row++) {
                        for (int col = 1; col <= row; col++) {
                                System.out.print('*');
                        }
                        System.out.println();
                }

		for (int row = 1; row <= 5; row++) {
                        for (int col = 1; col <= 5; col++) {
                                System.out.print(col);
                        }
                        System.out.println();
                }

		for (int row = 1; row <= 5; row++) {
                        for (int col = 1; col <= row; col++) {
                                System.out.print(row);
                        }
                        System.out.println();
                }

		for (int row = 1; row <= 10; row++) {
                        for (int col = 1; col <= 10; col++) {
                                System.out.print((row * col) + "\t");
                        }
                        System.out.println();
                }

		System.out.println("************ Coding Challenge ************");
		for (int row = 1; row <= height; row++) {
			for (int col = 1; col <= width; col++) {
				if (row == height || row == 1) {
					System.out.print('*');
				} else if (col == width || col == 1) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}

		int n = 5;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n - row; col++) {
				System.out.print(' ');
			}
			for (int col = 1; col <= row; col++) {
				System.out.print(col);
			}
			for (int col = row - 1; col > 0; col--) {
				System.out.print(col);
			}
			System.out.println();
		}

//    1
//   121
//  12321
// 1234321
//123454321

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n - row; col++) {
				System.out.print(' ');
			}
			for (int col = 1; col <= row + (row - 1); col++) {
				System.out.print('*');
			}
			//for (int col = row - 1; col > 0; col--) {
                        //      System.out.print('*');
                        //}
			System.out.println();
		}

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n - row; col++) {
				System.out.print(' ');
			}
			for (int col = 1; col <= row + (row - 1); col++) {
				System.out.print(row);
			}
			//for (int col = row - 1; col > 0; col--) {
			//	System.out.print(row);
			//}
			System.out.println();
		}
	}
}
