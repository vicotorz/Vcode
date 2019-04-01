package jingdongpractice;

import java.util.Scanner;

public class Main5 {
	public static int Sum10(int n) {
		int sum = 0;
		int shang = n;
		int yu = n;
		while (shang != 0 || yu != 0) {
			yu = shang % 10;
			shang = shang / 10;
			sum += yu;
		}
		return sum;
	}

	public static int Sum2(int n) {
		int sum = 0;
		int shang = n;
		int yu = n;
		while (shang != 0 || yu != 0) {
			yu = shang % 2;
			shang = shang / 2;
			sum += yu;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			int n = Integer.valueOf(line);
			int result = 0;
			for (int i = 1; i <= n; i++) {
				if (Sum2(i) == Sum10(i)) {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
