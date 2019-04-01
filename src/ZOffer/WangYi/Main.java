package WangYi;

import java.util.Scanner;

public class Main {
	public static int countDay(int x, int f, int d, int p) {
		if (d <= 0 || x > d || (x == 0 && p == 0)) {
			return 0;
		}

		int days = 0;
		// 先消耗已经有的水果
		if (f > 0) {
			if (x * f < d) {
				days += f;
				d = d - x * f;
				f = 0;
			} else {
				days = days + d / x;
				d = d - d / x;
			}
		}
		if (d > 0 && f == 0) {
			// 没有水果，开始购买
			days += (d / (x + p));
		}
		return days;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] str = line.split(" ");
			int x = Integer.valueOf(str[0]);
			int f = Integer.valueOf(str[1]);
			int d = Integer.valueOf(str[2]);
			int p = Integer.valueOf(str[3]);
			System.out.println(countDay(x, f, d, p));
		}
		sc.close();
	}
}
