package HuffmanTree;
import java.util.List;

public class HuffmanTree {

	/**
	 * 2014.6.27
	 * 
	 * @param args
	 *            哈夫曼树的构造
	 * 
	 *            作者：张迪Victorz
	 * 
	 *            参考：李刚《疯狂Java程序员的基本修养》
	 * 
	 *            备注：时间有点紧，理解不是很深
	 */

	// 节点
	public class Node {
		String name;
		int weight;
		Node leftch;
		Node rightch;

		public Node(String name, int weight) {
			this.name = name;
			this.weight = weight;

		}
	}

	// 构造哈夫曼树
	// 逆序和顺序没有关系
	public Node createTree(List<Node> nodes) {

		// 输入：跟节点的最小的两个节点
		// 输出：合并后的父节点
		while (nodes.size() > 1) {
			System.out.println(nodes.size());
			// 1.获得nodes中最小的两个点
			quickSort(nodes);

			Node minNode1 = nodes.get(0);
			Node minNode2 = nodes.get(1);
			System.out.println("得到两个最小点为" + minNode1.name + "----"
					+ minNode2.name);

			// 2.合并
			Node parent = new Node(null, minNode1.weight + minNode2.weight);
			System.out.println("合并的点为权值" + parent.weight);
			// 处理一下
			parent.leftch = minNode1;
			parent.rightch = minNode2;

			// 3.删除这两个点
			// 这里不能这么写！！！
			// nodes.remove(0);
			// nodes.remove(1);

			nodes.remove(0);
			nodes.remove(0);

			// 4.将合并的新的点加入
			nodes.add(parent);
		}

		// 5.返回跟节点
		return nodes.get(0);// 这个就是跟节点了

		// 结束
	}

	// 快速排序算法

	// 思路有些混乱！

	/**
	 * 快速排序 输入节点列表，开始和结束的数字
	 * */
	public void Sort(List<Node> nodes, int start, int end) {
		if (start < end) {
			Node base = nodes.get(start);
			int i = start;
			int j = end + 1;
			while (true) {
				// 确定i和j的位置
				while (i < end && nodes.get(++i).weight <= base.weight)
					;
				while (j > start && nodes.get(--j).weight >= base.weight)
					;
				if (i < j) {
					// 交换值
					Node temp;
					temp = nodes.get(i);
					nodes.set(i, nodes.get(j));
					nodes.set(j, temp);

				} else {
					break;
				}
			}

			// 最后将第一个地方的值处理一下
			Node temp;
			temp = nodes.get(start);
			nodes.set(start, nodes.get(j));
			nodes.set(j, temp);

			// 继续递归
			Sort(nodes, start, j - 1);
			Sort(nodes, j + 1, end);

		}
	}

	// 调用这个函数
	public void quickSort(List<Node> nodes) {
		Sort(nodes, 0, nodes.size() - 1);
	}

	// 输出(这个都不是很难)
	public void showall(Node cur) {

		// 采用先序序列遍历树(也可采用中序和后序)

		if (cur == null) {
			return;
		}
		System.out.println(cur.name + "----" + cur.weight);
		showall(cur.leftch);
		showall(cur.rightch);

	}

}
