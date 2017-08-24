package ZOffer;

import ZOffer.BalancedTree.TreeNode;

public class Mirror {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode Mirror(TreeNode root) {
		TreeNode left = root.left;
		TreeNode right = root.right;
		System.out.println(left + "," + right);

		if (left == null && right == null) {
			return null;
		}
		if (left != null && right == null) {
			// 交换
			root.right = root.left;
			root.left = null;
			return root;
		}
		if (left == null && right != null) {
			// 交换
			root.left = root.right;
			root.right = null;
			return root;
		}
		if (left != null && right != null) {
			Mirror(root.left);
			Mirror(root.right);
			TreeNode temp = left;
			root.left=root.right;
			root.right=temp;
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		TreeNode result = Mirror(node1);
		System.out.println(result.val + "," + result.left.val + "," + result.right.val);
	}

}
