package Tree;

public class minDepth {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void run(TreeNode root) {
		TreeNode s = root;
		System.out.println(height(s));
	}

	public int height(TreeNode node) {
		int height = 0;
		if (node != null) {
			if (node.left == null && node.right != null) {
				return 1 + height(node.right);
			}
			if (node.right == null && node.left != null) {
				return 1 + height(node.left);
			}
			height = 1 + Math.min(height(node.left), height(node.right));
		}
		return height;
	}

	public void build() {
		TreeNode s1 = new TreeNode(1);
		TreeNode s2 = new TreeNode(2);
		TreeNode s3 = new TreeNode(3);
		// TreeNode s4 = new TreeNode(4);
		//
		TreeNode s5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		s1.left = s2;
		s1.right = s3;
		// s2.left = s4;
		// s2.right = s5;
		// s3.left = s7;
		// s4.left = s6;
		run(s1);
	}

	public static void main(String[] args) {
		new minDepth().build();
	}
}
