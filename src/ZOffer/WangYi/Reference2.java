package WangYi;

import java.util.Arrays;
import java.util.Scanner;

public class Reference2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] X = new int[n];
		int[] Y = new int[n];
		for (int i = 0; i < n; i++) {
			X[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			Y[i] = scan.nextInt();
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int[] res2 = new int[n];
					for (int l = 0; l < n; l++) {
						res2[l] = Math.abs(X[l] - X[j]) + Math.abs(Y[l] - Y[k]);
					}
					Arrays.sort(res2);
					for (int e : res2) {
						System.out.print(e + ",");
					}
					System.out.println();
					int res3 = 0;
					for (int l = 0; l <= i; l++) {
						res3 = res3 + res2[l];
					}
					res[i] = Math.min(res3, res[i]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (i < n - 1) {
				System.out.print(res[i] + " ");
			} else {
				System.out.print(res[i]);
			}
		}
	}
}