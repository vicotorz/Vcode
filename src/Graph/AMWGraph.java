package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description 邻接矩阵模型类
 * @author victor
 */
public class AMWGraph {

	public String[][] edgesName;// 边名称
	public int[][] edges;// 邻接矩阵，用来存储边 初始的值为0
	public int numOfEdges;// 边的数目
	private ArrayList vertexList;// 存储点的链表
	public boolean[] isVisited;

	// 初始化
	public AMWGraph(int n) {
		// 初始化矩阵，一维数组，和边的数目
		edges = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				edges[i][j] = -1;
			}
		}
		edgesName = new String[n][n];
		numOfEdges = 0;
		vertexList = new ArrayList(n);

	}

	// 返回v1,v2的权值
	public double getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// 返回存储的边的名称
	public String getlinkName(int v1, int v2) {
		return edgesName[v1][v2];
	}

	// 得到边的数目
	public int getNumOfEdges() {
		return numOfEdges;
	}

	// 插入结点
	public void insertEdge(int v1, int v2, int weight, String linkName) {
		edges[v1][v2] = weight;
		edgesName[v1][v2] = linkName;
		numOfEdges++;
	}

	// 删除结点
	public void deleteEdge(int v1, int v2) {
		edges[v1][v2] = 0;
		edgesName[v1][v2] = null;
		numOfEdges--;
	}

	// 得到第一个邻接结点的下标
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	// 根据前一个邻接结点的下标来取得下一个邻接结点
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	// 返回结点i的数据
	public Object getValueByIndex(int i) {
		return vertexList.get(i);
	}

	// 得到结点的个数
	public int getNumOfVertex() {
		return vertexList.size();
	}

	// 私有函数，深度优先遍历
	private void depthFirstSearch(boolean[] isVisited, int i) {
		// 首先访问该结点，在控制台打印出来
		System.out.print(getValueByIndex(i) + "  ");
		// 置该结点为已访问
		isVisited[i] = true;

		int w = getFirstNeighbor(i);//
		while (w != -1) {
			if (!isVisited[w]) {
				depthFirstSearch(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	// 对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
	public void depthFirstSearch() {
		isVisited = new boolean[getNumOfVertex()];
		Arrays.fill(isVisited, false);
		for (int i = 0; i < getNumOfVertex(); i++) {
			// 因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
			if (!isVisited[i]) {
				depthFirstSearch(isVisited, i);
			}
		}
	}

	// 私有函数，广度优先遍历
	private void broadFirstSearch(boolean[] isVisited, int i) {
		int u, w;
		LinkedList queue = new LinkedList();

		// 访问结点i
		System.out.print(getValueByIndex(i) + "  ");
		isVisited[i] = true;
		// 结点入队列
		queue.addLast(i);
		while (!queue.isEmpty()) {
			u = ((Integer) queue.removeFirst()).intValue();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					// 访问该结点
					System.out.print(getValueByIndex(w) + "  ");
					// 标记已被访问
					isVisited[w] = true;
					// 入队列
					queue.addLast(w);
				}
				// 寻找下一个邻接结点
				w = getNextNeighbor(u, w);
			}
		}
	}

	// 对外公开函数，广度优先遍历
	public void broadFirstSearch() {
		isVisited = new boolean[getNumOfVertex()];
		Arrays.fill(isVisited, false);
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				broadFirstSearch(isVisited, i);
			}
		}
	}

}