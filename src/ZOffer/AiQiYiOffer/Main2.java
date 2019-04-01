package AiQiYiOffer;

import java.util.Scanner;

public class Main2 {

	public static int Count(int n, int m) {
		// 如果ab能开根号就行 ab=1,4,9,16,25....
		int result = 0;
		int maxstep = (int) Math.floor(Math.sqrt(Double.valueOf(n) * Double.valueOf(m)));
		for (int k = 1; k <= maxstep; k++) {
			int target = k * k;
			for (int i = 1; i <= n; i++) {
//				if (target / i > m) {
//					continue;
//				}

				if (target / i <= m && target % i == 0) {
					result++;
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int n = Integer.valueOf(str[0]);
			int m = Integer.valueOf(str[1]);
			System.out.println(Count(n, m));
		}
		sc.close();
	}

}
