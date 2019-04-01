package moni;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public int calculate(int number, int[] pow) {
		int result = 0;
		Arrays.sort(pow);
		// 去掉最大值，去掉最小值
		// 取最大number个数即可
		// 找到
		int index = pow.length - 2;
		for (int i = 0; i < number; i++) {
			result = result + pow[index];
			index--;
		}
		return result;
	}

	public static void main(String[] args) {
		Main1 m = new Main1();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			// 去掉最大值，去掉最小值
			String people = sc.nextLine();
			int number = Integer.valueOf(people);
			String[] power = sc.nextLine().split(" ");
			int[] pow = new int[power.length];
			for (int i = 0; i < power.length; i++) {
				pow[i] = Integer.valueOf(power[i]);
			}
			if (number <= 0) {
				System.out.println(0);
			} else {
				System.out.println(m.calculate(number, pow));
			}

		}
	}
}
