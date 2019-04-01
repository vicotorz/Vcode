package Shunfeng;

import java.util.Scanner;

public class Main {

	public static int count = 0;

	public static void fun(int target, int jinzhi, String result) {
		// System.out.println(jinzhi + ",,," + result);
		if (Integer.valueOf(result) <= target) {
			// System.out.println(Integer.valueOf(result) + "," + target + "," +
			// (Integer.valueOf(result) <= target));
			System.out.println("可以:" + result);
			count++;
		}
		if (jinzhi == 1) {
			jinzhi++;// 关键点
			return;
		}
		fun(target, jinzhi - 1, "4" + result);
		fun(target, jinzhi - 1, "7" + result);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		int number = Integer.valueOf(sc.nextLine());
		int temp = number;
		int jinzhi = 0;
		while (temp > 0) {
			temp = temp / 10;
			jinzhi++;
		}
		// System.out.println(jinzhi);
		fun(number, jinzhi, "4");
		fun(number, jinzhi, "7");
		System.out.println(count);

	}
}
