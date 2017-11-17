package ZOffer;

import java.util.Stack;

import ZOffer.BalancedTree.TreeNode;

public class MirrorTree {
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.left != null || node.right != null) {
				TreeNode nodeLeft = node.left;
				TreeNode nodeRight = node.right;
				node.left = nodeRight;
				node.right = nodeLeft;
			}
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
	}
}
