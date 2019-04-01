package dongtaiguihua;
/*
 * 最优方式找钱
 * */

public class zhaoqian {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 6 };
		System.out.println(new zhaoqian().countWays(arr, 3, 13));
		int a = 1, x = 2;
		a = x > 1 ? 5 * x : (x = 7);
		System.out.println(a + "--" + x);
	}

	public int countWays(int[] penny, int n, int aim) {
		// write code here
		int[][] dp = new int[n][aim + 1];// 方法数
		// dp第一行为 penny[i]整数倍的 设置为1
		// dp第一列都为1
		for (int j = 0; j <= aim; j++) {
			if (j % penny[0] == 0) {
				dp[0][j] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				int sum = 0;
				for (int t = j; t >= 0; t--) {
					// 使用t张penny[i]组成钱数j的方法数
					int loc = j - t * penny[i];
					if (loc >= 0) {
						sum = sum + dp[i - 1][loc];
					}
				}
				dp[i][j] = sum;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= aim; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[n - 1][aim];
	}
}
