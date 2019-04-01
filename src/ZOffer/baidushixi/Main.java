package baidushixi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public int getthree(int[] price, int number) {

		Arrays.sort(price);
		// 找到最小的第三个数
		// 返回
		int mincount = 1;
		int min = price[0];
		for (int i = 0; i < number; i++) {
			if (mincount == 3) {
				break;
			}
			if (price[i] > min) {
				min = price[i];
				mincount++;
			}
		}
		if (mincount != 3 || min <= 0) {
			return -1;
		} else {
			return min;
		}
	}

	public static void main(String[] args) {
		try {
			Main m = new Main();
			Scanner sc = new Scanner(System.in);
			// while (sc.hasNextLine()) {
			int number = Integer.valueOf(sc.nextLine());
			if (number <= 2) {
				System.out.println(number);
				throw new Exception();
			}
			String str = sc.nextLine();
			String[] s = str.split(" ");
			int[] price = new int[number];
			for (int i = 0; i < number; i++) {
				price[i] = Integer.valueOf(s[i]);
			}
			// int[] price = { 10, 40, 50, 20, 70, 80, 30, 90, 60 };
			// int number = 9;
			System.out.println(m.getthree(price, number));
			// }
		} catch (Exception e) {
			// System.out.println(e);
			e.printStackTrace();
			System.out.println(-1);
		}
	}
}
