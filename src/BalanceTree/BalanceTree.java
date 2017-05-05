package BalanceTree;
import java.util.List;

public class BalanceTree {

	/**
	 * 平衡树的实现
	 * 
	 * 2014.6.29晚
	 * 
	 * 作者：张迪
	 * 
	 * 备注：利用哈夫曼树建立的思想，构建相关的平衡树。
	 * 
	 * 
	 */

	class Node {
		Object data;
		Node leftch;
		Node rightch;

		Node() {

		}

		Node(Object data) {
			this.data = data;
			this.leftch = this.rightch = null;
		}

		Node(Object data, Node leftch, Node rightch) {
			this.data = data;
			this.leftch = leftch;
			this.rightch = rightch;

		}

	}

	//创建平衡树
	public Node CreateTree(List<Node> list, int left, int right) {
		// 1.排序（暂时不考虑）
		System.out.println("比较这里传进的值    left--" + left + "--right--" + right);

		// 2.递归出口（当取中点后的值和边界距离只有2时）
		// 第次调用这个可以进行
		if (right - left == 0) {

			return new Node(list.get(left).data, null, null);
		}
		// 需要这个判断,否则会绕圈递归
		if (right < left) {
			return null;
		}

		// 3.取中间的节点（取上顶）
		Node node = new Node();
		int med;
		if ((right - left) % 2 == 0) {
			med = left + (right - left) / 2;
		} else {
			med = left + (right - left + 1) / 2;
		}
		System.out.println("此时建立的节点为" + med);
		node.data = list.get(med).data;
		// 4.建立左子树
		node.leftch = CreateTree(list, left, med - 1);
		// 5.建立右子树
		node.rightch = CreateTree(list, med + 1, right);

		return node;
	}

	public void showall(Node cur) {

		// 采用先序序列遍历树(也可采用中序和后序)

		if (cur == null) {
			return;
		}
		System.out.println(cur.data + " ");
		showall(cur.leftch);
		showall(cur.rightch);

	}
}
