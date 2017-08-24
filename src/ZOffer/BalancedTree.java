package ZOffer;

public class BalancedTree {
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

	public static boolean IsBalanced_Solution(TreeNode root) {
		// 左小右大
		int leftvalue = 0;
		int leftdepth = 0;
		int rightvalue = 0;
		int rightdepth = 0;
		if (root.left != null) {
			leftvalue = root.left.val;
			leftdepth = TreeDepth(root.left);
		}
		if (root.right != null) {
			rightvalue = root.right.val;
			rightdepth = TreeDepth(root.right);
		}
		if (Math.abs(leftdepth - rightdepth) <= 1 && leftvalue < root.val && rightvalue > root.val) {
			return true;
		}
		if (root.left != null) {
			IsBalanced_Solution(root.left);
		}
		if (root.right != null) {
			IsBalanced_Solution(root.right);
		}
		return false;
	}
	
	public static boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null)
            return true;
 
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1)
            return false;
 
         
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
 
    }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		node1.left = node2;
		node2.left = node3;
		System.out.println(IsBalanced_Solution1(node1));
	}
}
