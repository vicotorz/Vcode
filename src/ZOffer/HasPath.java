package ZOffer;

public class HasPath {
	// 训练回溯方法
	public static boolean hasPath(String[][] path, int rows, int cols, String str) {
		if (path == null) {
			return false;
		}

		boolean[][] visited = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (check(path, i, j, rows, cols, visited, str, 0)) {
					return true;
				}
			}

		}
		return false;
	}

	public static boolean check(String[][] path, int i, int j, int rows, int cols, boolean[][] visited, String str,
			int strindex) {
		System.out.println(i + "," + j + "," + strindex);
		// System.out.println(i + "," + j + "," + path[i][j] + "," +
		// str.charAt(strindex) + "," + visited[i][j]);
		boolean hasPath = false;
		if (i >= 0 && i < rows && j >= 0 && j < cols && strindex < str.length()
				&& path[i][j].equals(String.valueOf(str.charAt(strindex))) && !visited[i][j]) {
			System.out.println("jinlaile");
			strindex++;
			visited[i][j] = true;
			hasPath = check(path, i, j + 1, rows, cols, visited, str, strindex)
					|| check(path, i, j - 1, rows, cols, visited, str, strindex)
					|| check(path, i + 1, j, rows, cols, visited, str, strindex)
					|| check(path, i - 1, j, rows, cols, visited, str, strindex);
			if (!hasPath) {
				strindex--;
				visited[i][j] = false;
			}

		}
		return hasPath;
	}

	public static void main(String[] args) {
		String[][] path = new String[3][4];
		path[0][0] = "a";
		path[0][1] = "b";
		path[0][2] = "t";
		path[0][3] = "g";

		path[1][0] = "c";
		path[1][1] = "f";
		path[1][2] = "c";
		path[1][3] = "s";

		path[2][0] = "j";
		path[2][1] = "d";
		path[2][2] = "e";
		path[2][3] = "h";

		System.out.println(hasPath(path, 3, 4, "bfce"));

	}

}
