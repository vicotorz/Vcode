package moni;

import java.util.Scanner;

public class Main {
	public int getNumber(int num, String[] str) {
		int count = 1;
		// 遇到递减或递增就开始计算
		// int max_min = Integer.valueOf(str[0]);
		int increase = 1;
		int decrease = 1;
		for (int i = 0; i < str.length - 1; i++) {
			if (Integer.valueOf(str[i]) > Integer.valueOf(str[i + 1]) && decrease != 1) {
				// 突然增
				//System.out.println(Integer.valueOf(str[i]) + "---" + Integer.valueOf(str[i + 1]));
				decrease = 1;
				count++;
				increase = 1;
			} else if (Integer.valueOf(str[i]) < Integer.valueOf(str[i + 1]) && increase != 1) {
				// 突然减
				//System.out.println(Integer.valueOf(str[i]) + "---" + Integer.valueOf(str[i + 1]));
				increase = 1;
				count++;
				decrease = 1;
			} else if (Integer.valueOf(str[i]) > Integer.valueOf(str[i + 1])) {
				// 增
				increase++;
			} else if (Integer.valueOf(str[i]) < Integer.valueOf(str[i + 1])) {
				// 减
				decrease++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String number = sc.nextLine();
			String[] str = sc.nextLine().split(" ");
			int num = Integer.valueOf(number);
			if (num <= 0) {
				System.out.println("0");
			} else if (num == 1) {
				System.out.println("1");
			} else {
				System.out.println(m.getNumber(num, str));
			}
		}
	}

}
