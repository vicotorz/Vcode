package dongtaiguihua;

/***
 * [1,4,2,5,3],5
 * */
public class LongestIncreasingSubsequence {
	public int getLIS(int[] A, int n) {
		// write code here
		if (null == A || 0 >= n)
			return 0;
		int[] dp = new int[n];
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j])
					max = Math.max(max, dp[j]);
			}
			dp[i] = max + 1;
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
