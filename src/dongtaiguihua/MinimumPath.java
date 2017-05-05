package dongtaiguihua;

import java.util.*;

public class MinimumPath {
	public int getMin(int[][] map, int n, int m) {
		// write code here
		int[][] path;
		if (n <= 0 || m < 0) {
			return 0;
		} else if (n == 1 && m == 1) {
			return map[n - 1][m - 1];
		} else if (n == 1 && m > 1) {
			path = new int[n][m];
			Arrays.fill(path, 0);
			path[0][0] = map[0][0];
			for (int i = 1; i < m; i++) {
				path[0][i] = path[0][i - 1] + map[0][i];
			}
			return path[0][m - 1];
		} else if (n > 1 && m == 1) {
			path = new int[n][m];
			Arrays.fill(path, 0);
			path[0][0] = map[0][0];
			for (int j = 1; j < n; j++) {
				path[j][0] = path[j - 1][0] + map[j][0];
			}
			return path[n - 1][0];
		} else {
			path = new int[n][m];
			for (int t = 0; t < n; t++) {
				Arrays.fill(path[t], 0);
			}
			path[0][0] = map[0][0];
			for (int i = 1; i < m; i++) {
				path[0][i] = path[0][i - 1] + map[0][i];
			}
			for (int j = 1; j < n; j++) {
				path[j][0] = path[j - 1][0] + map[j][0];
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					path[i][j] = Math.min(map[i][j] + path[i - 1][j], map[i][j]
							+ path[i][j - 1]);
				}
			}
			return path[n - 1][m - 1];
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 1, 1, 1 } };
		MinimumPath m = new MinimumPath();
		System.out.println(m.getMin(a, 2, 3));
	}
}