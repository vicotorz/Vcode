package jingdongpractice;

import java.util.Scanner;

public class Main3 {
	public static int SumCount(int A, int n) {
		int sum = 0;
		int shang = A;
		int yu = A;
		while (shang != 0 || yu != 0) {
			yu = shang % n;
			shang = shang / n;
			sum += yu;
		}
		return sum;
	}

	public static int ZuidaGongyue(int x, int y) {
		if (x < y) {
			return ZuidaGongyue(y, x);
		}
		if (y == 0)
			return x;
		else
			return ZuidaGongyue(x - y, y);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			int A = Integer.valueOf(line);
			// 从2-(A-1)进制
			int fenzi = 0;
			int fenmu = A - 2;
			if (A <= 2) {
				System.out.println(A);
			}
			int zuidagongyue = 1;
			for (int i = 2; i <= (A - 1); i++) {
				fenzi += SumCount(A, i);
				zuidagongyue = ZuidaGongyue(fenzi, fenmu);
			}
			System.out.println((fenzi / zuidagongyue) + "/" + (fenmu / zuidagongyue));
		}
	}
}
