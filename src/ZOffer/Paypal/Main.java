package Paypal;

import java.util.Scanner;

public class Main {
	// 吃鱼函数
	public void eatfish(int[] A, int[] B, int size) {
		// <--(-1) -->(1)
		// 出现-1，1就合并
		int totalfish = size;
		int pre;
		int behind;
		if (size >= 2) {
			for (int i = 0; i < size - 1; i++) {
				pre = B[i];
				behind = B[i + 1];
				if ((pre == -1 && behind == 1) || (pre == 1 && behind == -1)) {
					totalfish--;
					B[i] = 0;
					B[i + 1] = 0;
				}
			}

			System.out.println(totalfish);
			for (int e : B) {
				System.out.print(e);
			}
			for (int t = 0; t < size; t++) {
				if (B[t] != 0) {
					totalfish--;
				}
			}
		} else {
			totalfish = 1;
		}
		System.out.println(totalfish);
	}

	public static void main(String[] args) {
		int[] A, B;
		int size;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line1 = sc.nextLine();
			String line2 = sc.nextLine();
			String[] s1 = line1.split(" ");
			String[] s2 = line2.split(" ");
			size = s1.length;
			A = new int[size];
			B = new int[size];
			// 开始赋值

			for (int i = 0; i < size; i++) {
				A[i] = Integer.valueOf(s1[i]);
				B[i] = Integer.valueOf(s2[i]);
			}

			Main m = new Main();
			m.eatfish(A, B, size);

		}
	}

}
