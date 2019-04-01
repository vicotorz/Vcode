package Haiwei_shixi;

import java.util.Scanner;

public class Main2 {

	public void findpath(int sta, int des, int[][] graph) {
		outer: for (int i = 0; i < graph[sta - 1].length && sta != des; i++) {
			System.out.println(i + "???" + (sta) + "???" + des + "???"
					+ graph[sta - 1][i]);
			if (graph[sta - 1][i] > 0) {
				System.out.println("--" + (i + 1));
				if ((i + 1) != des) {
					sta = i + 1;
					findpath(sta, des, graph);
				} else {
					System.out.println("zhaodaole");
					// break outer;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 2, 10, 5, 3, -1 }, { -1, 0, 12, -1, -1, 10 },
				{ -1, -1, 0, -1, 7, -1 }, { 2, -1, -1, 0, 2, -1 },
				{ 4, -1, -1, 1, 0, -1 }, { 3, -1, 1, -1, 2, 0 } };
		Main2 m = new Main2();
		Scanner sc = new Scanner(System.in);
		int dest = sc.nextInt();
		int error = sc.nextInt();
		// 对error行列进行赋值
		for (int i = 0; i < 6; i++) {
			graph[error - 1][i] = -1;
			graph[i][error - 1] = -1;
		}
		// for (int j = 0; j < 6; j++) {
		// for (int t = 0; t < 6; t++) {
		// System.out.print(graph[j][t] + " ");
		// }
		// System.out.println();
		// }
		// 编程思路 数组的广度遍历
		// 从start列找大于0的，然后依次遍历
		// System.out.print(5);
		m.findpath(5, dest, graph);

	}

}
