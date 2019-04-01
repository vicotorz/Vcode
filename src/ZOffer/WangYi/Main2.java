package WangYi;

import java.util.Scanner;

public class Main2 {
	static int[] dp;
	static int[] sum;

	public static int dp(int n, int k) {
		sum = new int[n];
		dp = new int[k];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if (j >= i || (i + 1) % (j + 1) != 0) {
					dp[i] += 1;
				}
			}
		}
		int sum = 0;
		for (int t = 0; t < k; t++) {
			sum += dp[t];
		}
		return sum;
	}

	public static int func(int n, int k) {
		if (k == 1) {
			return 1;
		}
		int result = 0;
		for (int i = 1; i < n; i++) {
			result += dp(n, k);
		}
		for(int e:dp){
			System.out.print(e+",");
		}
		System.out.println();
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int n = Integer.valueOf(str[0]);
			int k = Integer.valueOf(str[1]);
			System.out.println(func(n, k));
		}
		sc.close();
	}
}
