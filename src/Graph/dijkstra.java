package Graph;

import java.util.Stack;

public class dijkstra {
	int[][] distance;// v0到各点的最短距离的初始值
	Stack<Integer> stack;
	int[][] path;
	// 顶点数
	private int number;

	// dijkstra函数
	/**
	 * 邻接矩阵
	 * 
	 * 初始节点
	 * 
	 * 结束节点
	 * 
	 * 每一次加入新节点V 比较dist【其他节点】 与 dist【V】+g【V】【其他节点】的大小 并更新dist数组
	 * 
	 * **/
	public void dijkstra(int[][] W1, int start, int end) {
		System.out.println("【调用dijkstra方法】");
		System.out.println(stack.size());
		stack.clear();
		System.out.println("现在开始" + start + "的dijkstra算法");

		for (int i = 0; i < W1[0].length; i++) {
			if (W1[start][i] != -1) {
				path[start][i] = start;
			} else {
				path[start][i] = -1;
			}
		}

		System.out.println("初始化结束");
		for (int r = 0; r < number; r++) {

			System.out.print(path[start][r] + " ");
		}
		System.out.println();

		System.out.println("起点:" + start + "终点:" + end);
		boolean[] isLabel = new boolean[W1[0].length];// 是否标号
		int[] indexs = new int[W1[0].length];// 所有标号的点的下标集合，以标号的先后顺序进行存储，实际上是一个以数组表示的栈
		int i_count = -1;// 栈的顶点

		int index = start;// 从初始点开始
		int presentShortest = 0;// 当前临时最短距离

		indexs[++i_count] = index;// 把已经标号的下标存入下标集中
		isLabel[index] = true;

		while (i_count < W1[0].length) {
			// 第一步：得到与原点最近的某个点
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < distance.length; i++) {
				if (!isLabel[i] && distance[start][i] != -1 && i != index) {// 如果这个点没被标号
					// ，有路径，而且不是起点本身
					// 如果到这个点有边,并且没有被标号
					if (distance[start][i] < min) {
						min = distance[start][i];
						index = i;// 把下标改为当前下标

					}
				}
			}
			i_count = i_count + 1;
			if (i_count == W1[0].length - 1) {// 说明找到了尽头
				break;
			}
			isLabel[index] = true;// 对点进行标号
			indexs[i_count] = index;// 把已经标号的下标存入下标集中

			if (W1[indexs[i_count - 1]][index] == -1
					|| presentShortest + W1[indexs[i_count - 1]][index] > distance[start][index]) {
				// 如果两个点没有直接相连，或者两个点的路径大于最短路径
				presentShortest = distance[start][index];
			} else {
				presentShortest += W1[indexs[i_count - 1]][index];
			}

			// 第二步：加入vi后，重新计算distance中的距离(加入了新的点，会让起点到其他点距离最短的话)
			for (int i = 0; i < distance.length; i++) {

				// 如果vi到那个点有边，则v0到后面点的距离加
				if (distance[start][i] == -1 && W1[index][i] != -1
						&& i != start) {// 如果以前不可达，则现在可达了
					// 起点到这个地方无通路，但是加入点后就可以到达了
					distance[start][i] = presentShortest + W1[index][i];
					path[start][i] = index;
				} else if (W1[index][i] != -1
						&& presentShortest + W1[index][i] < distance[start][i]) {
					// 如果以前可达，但现在的路径比以前更短，则更换成更短的路径
					distance[start][i] = presentShortest + W1[index][i];
					path[start][i] = index;
				}

			}

		}
		System.out.println("调用过后，此时的path为：");
		for (int i = 0; i < number; i++) {
			System.out.print(path[start][i] + " ");
		}
		System.out.println();
	}

}
