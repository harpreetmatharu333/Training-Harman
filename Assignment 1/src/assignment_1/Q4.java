package assignment_1;

import java.util.Scanner;

public class Q4 {
	public static void main(String args[]) {// opening of main
		Scanner sc = new Scanner(System.in);
		int n, i, j, a[][];
		
		System.out.println("HOW MANY STEPS?");
		n = sc.nextInt();
		a = new int[n][n];
		 
		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++)
				if (j == 0 || j == i)
					a[i][j] = 1;
				else
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
		}
		
		System.out.println("\nOUTPUT:\n");
		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++)
				System.out.print(a[i][j] + "\t");

			System.out.println();
		}
	}

}
