package Graph;

import java.util.Arrays;

public class Floyed {
	/**
	 * 两个节点之间的最短距离
	 * **/
	// 以key为中间点 检测 A[i][j] A[i][key]+A[key][j]
	// 如果A[i][j]>A[i][key]+A[key][j]
	// 则A[i][j]改为A[i][key]+A[key][j]
	// path[i][j]改为key
	public void Floyed(int[][] A, int[][] path) {
		int size = A[0].length;
		for (int key = 0; key < size; key++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (A[i][j] > A[i][key] + A[key][j]) {
						A[i][j] = A[i][key] + A[key][j];
						path[i][j] = key;
					}
				}
			}

		}
		System.out.println("----");
		PP(A, path);
	}

	public void PP(int[][] A, int[][] path) {
		int size = A[0].length;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print(A[x][y] + " ");
			}
			System.out.println();
		}

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print(path[x][y] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] A = { { 0, 5, 100, 7 }, { 100, 0, 4, 2 }, { 3, 3, 0, 2 },
				{ 100, 100, 1, 0 } };
		int[][] path = { { -1, -1, -1, -1 }, { -1, -1, -1, -1 },
				{ -1, -1, -1, -1 }, { -1, -1, -1, -1 } };
		Floyed f = new Floyed();
		f.Floyed(A, path);
	}
}
