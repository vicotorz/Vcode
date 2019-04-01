package PingAnOffer;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main1 {
	public static int fun(int n) {
		// 5的次数
		int count = 0;
		// 如果数字小于5 直接返回0
		if (n < 5)
			return 0;
		// 遍历5到n 之间的数
		for (int i = 5; i <= n; i++) {
			int num = i;
			// 计算这个数包含5的个数
			while ((num % 5 == 0) && (num >= 5)) {
				num = num / 5;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			System.out.println(fun(n));
		}
		sc.close();

	}

}
