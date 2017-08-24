package ZOffer;

public class SubTree {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	// root2可能是一个很庞大的树，不一定是一个很简单的单元结构
	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = DoesTree1HasTree2(root1, root2);
			}
			if (!result && root1.left != null) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result && root1.right != null) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	public static boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {

		if (root2 == null) {
			//System.out.println("root2 null");
			return true;
		}
		if (root1 == null || root1.val != root2.val) {
			//System.out.println("root1 null");
			return false;
		}
		//System.out.println(root1.val + "," + root2.val);
		return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
	}

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(8);
		TreeNode tn2 = new TreeNode(8);
		TreeNode tn3 = new TreeNode(7);
		TreeNode tn4 = new TreeNode(9);
		TreeNode tn5 = new TreeNode(2);
		TreeNode tn6 = new TreeNode(4);
		TreeNode tn7 = new TreeNode(7);
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn5.left = tn6;
		tn5.right = tn7;

		TreeNode tn9 = new TreeNode(8);
		TreeNode tn10 = new TreeNode(9);
		TreeNode tn11 = new TreeNode(2);
		tn9.left = tn10;
		tn9.right = tn11;

		System.out.println(HasSubtree(tn1, tn9));

	}

}
