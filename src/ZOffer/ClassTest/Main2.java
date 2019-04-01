package ClassTest;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void fun(int n, int[] bian) {
		if (n <= 0) {
			System.out.println(0);
			return;
		}
		int count = 0;
		Arrays.sort(bian);
		for (int a = 0; a < n - 1; a++) {
			for (int b = a + 1; b < n; b++) {
				count = count + Cou(bian, Math.abs(bian[a] - bian[b]), bian[a] + bian[b], a, b);
			}
		}
		System.out.println(count);
	}

	public static int Cou(int[] bian, int min, int max, int a, int b) {
		//System.out.println(min + " " + max + " " + a + " " + b);
		int tempcount = 0;
		for (int i = a + 1; i < b; i++) {
			//System.out.println(bian[i]);
			if (bian[i] > min && bian[i] < max) {
				tempcount++;
			}
		}
		return tempcount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			String[] str = sc.nextLine().split(" ");
			int[] bian = new int[n];
			for (int i = 0; i < n; i++) {
				bian[i] = Integer.valueOf(str[i]);
			}
			fun(n, bian);
		}
		sc.close();

	}

}
