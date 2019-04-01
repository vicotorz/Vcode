package ZDaJiang;

//0    r    a    b    b    b    i    t
//0    1    1    1    1    1    1    1    1
//r    0    1    1    1    1    1    1    1
//a    0    0    1    1    1    1    1    1
//b    0    0    0    1    2    3    3    3
//b    0    0    0    0    1    3    3    3
//i    0    0    0    0    0    0    3    3
//t    0    0    0    0    0    0    0    3
//Here is an example: S = "rabbbit", T = "rabbit"
//
//Return 3.
public class Reference {
	public int numDistinct(String s, String t) {
		int n = s.length(), m = t.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s.charAt(j - 1) == t.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}
}
