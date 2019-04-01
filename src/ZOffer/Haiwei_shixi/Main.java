package Haiwei_shixi;

import java.util.Scanner;

public class Main {

	// 输入范围 1~70000
	public double reverseAdd(int a, int b) {
		double result = -1;
		// 检测
		if (a < 1 || a > 70000 || b < 1 || b > 70000) {
			result = -1;
		} else {
			// 开始进行反转加和
			result = reverse(a) + reverse(b);
		}

		return result;
	}

	public double reverse(int a) {
		//System.out.println(a);
		// 除以10 取整取余数
		String s = String.valueOf(a);
		char[] ss = s.toCharArray();
		int size = ss.length;
		double sum = 0;
		for (int i = 1; i <= size; i++) {
			int temp1 = a / 10;
			int temp2 = a % 10;
			sum = sum + temp2 * Math.pow(10, size - i);
			a = temp1;
		}
		return sum;
	}

	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(",");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			System.out.println((int) m.reverseAdd(a, b));
		}

	}
}
