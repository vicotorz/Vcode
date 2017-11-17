package Tree;

import java.util.Stack;

import Tree.reBuildTree.TreeNode;

/**
 * 8 / \ 6 10 / \ / \ 5 7 9 11 镜像二叉树 8 / \ 10 6 / \ / \ 11 9 7 5
 * 
 */
public class MirrorTree {
	// 二叉树镜像
	// 基本单位
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
