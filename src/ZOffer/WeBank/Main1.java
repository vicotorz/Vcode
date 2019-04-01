package WeBank;

import java.util.Scanner;

public class Main1 {
	public static void fun(int n) {
		// 2~n进制
		int max = Integer.MIN_VALUE;
		int sum = 0, d;
		int temp = n;
		for (int Jin = 2; Jin <= n; Jin++) {
			sum = 0;
			temp = n;
			while (temp > 0) {
				d = temp % Jin;
				temp = temp / Jin;
				sum += d;
			}
			//System.out.println(Jin + "," + sum);
			if (sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			fun(n);
		}
		sc.close();
	}

}
