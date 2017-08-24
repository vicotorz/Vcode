package ZOffer;

public class DepthOfTree {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static int TreeDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		// 左右最大
		return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));

	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		System.out.println(TreeDepth(node1));
	}
}
