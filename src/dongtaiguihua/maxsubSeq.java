package dongtaiguihua;

public class maxsubSeq {
	public static void main(String[] args) {
		String A = "zynnqufc";
		String B = "ddbauhkw";
		System.out.println(new maxsubSeq().findLCS(A, 8, B, 8));
	}

	public int findLCS(String A, int n, String B, int m) {
		// write code here
		int[][] dp = new int[n][m];
		// A[0-i]与B[0-j]匹配数
		boolean f1 = false, f2 = false;
		for (int i = 0; i < n; i++) {
			if (f1) {
				dp[i][0] = 1;
				continue;
			}
			if (B.charAt(0) == A.charAt(i)) {
				f1 = true;
				dp[i][0] = 1;
			}
		}
		for (int j = 0; j < m; j++) {
			if (f2) {
				dp[0][j] = 1;
				continue;
			}
			if (A.charAt(0) == B.charAt(j)) {
				f2 = true;
				dp[0][j] = 1;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n - 1][m - 1];
	}
}
