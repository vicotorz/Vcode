package ClassTest;

import java.util.Scanner;

public class Main4 {

	public static int findLCS(String A, int n, String B, int m) {
		if (A.isEmpty() || B.isEmpty()) {
			return 0;
		}
		int maxresult = 0;
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
			maxresult = Math.max(maxresult, dp[i][0]);
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
			maxresult = Math.max(maxresult, dp[0][j]);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
					// Math.max(dp[i - 1][j], dp[i][j - 1])
				}
				maxresult = Math.max(maxresult, dp[i][j]);
			}
		}
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.print(dp[i][j] + " ");
		// }
		// System.out.println();
		// }
		return maxresult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String A = sc.nextLine();
			String B = sc.nextLine();
			System.out.println(findLCS(A, A.length(), B, B.length()));
		}
		sc.close();

	}

}
