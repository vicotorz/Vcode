public class alibaba {
	public static int getMaxScore(int[] score) {
		int coins = 0;
		int zeroNextPosition = 0;
		for (int i = 0; i < score.length - 1; i++) {
			if (score[i] == 0) {
				coins += countPartMaxScore(score, zeroNextPosition, i - zeroNextPosition);
				zeroNextPosition = i + 1;
			}
		}

		coins += countPartMaxScore(score, zeroNextPosition, score.length - zeroNextPosition);

		return coins;
	}

	public static int countPartMaxScore(int[] score, int start, int countLength) {
		System.out.println("[初始]" + start + "," + countLength);
		int length = countLength + 2;
		int[] scoreSubset = new int[length];
		System.arraycopy(score, start, scoreSubset, 1, countLength);
		scoreSubset[0] = scoreSubset[length - 1] = 1;
		for (int i = 0; i < length; i++) {
			System.out.print(scoreSubset[i] + ",");
		}
		System.out.println();
		int[][] dp = new int[length][length];
		for (int k = 2; k < length; k++) {
			for (int left = 0; left < length - k; left++) {
				int right = left + k;
				System.out.println("K:" + k + ",left:" + left + ",right:" + right);
				for (int i = left + 1; i < right; i++) {
					System.out.println("(" + left + "," + i + ")[" + dp[left][i] + "]+"
							+ scoreSubset[left] * scoreSubset[i] * scoreSubset[right] + "+(" + i + "," + right + ")["
							+ dp[left][i] + "]or" + dp[left][right]);
					dp[left][right] = Math.max(dp[left][right],
							dp[left][i] + scoreSubset[left] * scoreSubset[i] * scoreSubset[right] + dp[i][right]);
				}
			}
		}
		System.out.println("[计算得]" + dp[0][length - 1]);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(dp[i][j] + ",");
			}
			System.out.println();
		}
		return dp[0][length - 1];
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 0, 3 };
		System.out.println(getMaxScore(array));
	}
}