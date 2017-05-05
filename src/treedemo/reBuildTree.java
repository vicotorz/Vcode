package treedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class reBuildTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		// StringBuffer sb1 = new StringBuffer();
		// StringBuffer sb2 = new StringBuffer();
		// for (int i = 0; i < pre.length; i++) {
		// sb1.append(pre[i]);
		// }
		//
		// for (int j = 0; j < in.length; j++) {
		// sb2.append(in[j]);
		// }
		// return build(sb1.toString(), sb2.toString());
		int pl = 0;
		int pr = pre.length - 1;
		int il = 0;
		int ir = in.length - 1;
		return establishtree(pre, in, pl, pr, il, ir);
	}

	public TreeNode establishtree(int[] pre, int[] in, int l1, int r1, int l2,
			int r2) {
		if (l1 > r1)
			return null;

		int i = 0;
		for (; i < in.length; i++) {
			if (in[i] == pre[l1])
				break;
		}
		TreeNode node = new TreeNode(in[i]);
		node.left = node.right = null;

		// l1+1 --- 【l1+i-l2】--推导。。
		// l2 --- i-1
		node.left = establishtree(pre, in, l1 + 1/* pre左子树左边界 */,
				l1 + i - l2/* pre左子树右边界 */, l2/* in左子树左边界 */, i - 1/* in左子树右边界 */);// ??

		// 【l1+i-l2】 +1 --- r1
		// i+1 --- r2
		node.right = establishtree(pre, in, l1 + i - l2 + 1/* pre左子树左边界 */,
				r1/* pre左子树右边界 */, i + 1/* in左子树左边界 */, r2/* in左子树右边界 */);

		return node;

		//

	}

	// public TreeNode build(String s1, String s2) {
	// System.out.println("[s1]" + s1 + "[s2]" + s2 + " [s2-size]" +
	// s2.length());
	// System.out.println(s1.charAt(0));
	// TreeNode root = new
	// TreeNode(Integer.valueOf(String.valueOf(s1.charAt(0))));
	// int med = s2.indexOf(s1.charAt(0));
	// if (s2.length() == 0) {
	// return null;
	// }
	// if (s2.length() == 1) {
	// return new TreeNode(Integer.valueOf(String.valueOf(s1.charAt(0))));
	// }
	// if (med >= 0) {
	// s1 = s1.substring(1, s2.length());
	// System.out.println(s2 + "..." + med);
	// String temp1 = s2.substring(0, med);
	// String temp2 = s2.substring(med + 1, s2.length());
	// root.left = build(s1, temp1);
	// root.right = build(s1, temp2);
	// }
	// // if (med - 1 >= 0 && s1 != null) {
	// // right = med - 1;
	// // s2 = s2.substring(0, right);
	// // root.left = build(s1, s2);
	// // } else if (med + 1 <= s2.length() - 1 && s1 != null) {
	// // left = med + 1;
	// // s2 = s2.substring(left, s2.length());
	// // root.right = build(s1, s2);
	// //
	// // }
	// return root;
	// }

	public void output(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println("建完了");
		System.out.println(root.val);
		output(root.left);
		output(root.right);
	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();

	}

	public int Fibonacci(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;

		}
		// if (n == 2) {
		// return 1 + Fibonacci(n - 1);
		// }

		return Fibonacci(n - 1) + Fibonacci(n - 2);

	}

	public int JumpFloor(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}

	public int JumpFloorII(int target) {
		return (int) Math.pow(2, target - 1);
	}

	public String LeftRotateString(String str, int n) {
		if (str.equals("")) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = n; i < str.length(); i++) {
				sb.append(str.charAt(i));
			}
			for (int j = 0; j < n; j++) {
				sb.append(str.charAt(j));
			}
			return sb.toString();
		}
	}

	public String ReverseSentence(String str) {
		if (str.equals(" ")) {
			return " ";
		} else {
			str = reverse(str);
			String[] s = str.split(" ");
			StringBuffer tsb = new StringBuffer();
			for (int t = 0; t < s.length - 1; t++) {
				tsb.append(reverse(s[t]) + " ");
			}
			tsb.append(reverse(s[s.length - 1]));
			return tsb.toString();
		}
	}

	public String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix.length == 0) {
			return new ArrayList<Integer>();
		} else {
			int lrow = 0;
			int rrow = matrix.length - 1;
			int lcolumn = 0;
			int rcolumn = matrix[0].length - 1;
			int size = (rrow + 1) * (rcolumn + 1);
			ArrayList<Integer> list = new ArrayList<Integer>();
			// 定义四种状态
			int status = 0;
			while (list.size() != size) {
				System.out.println(list.size());

				if (status > 3) {
					status = 0;
				}
				System.out.println("===" + status);
				if (status == 0) {
					// 行不动 列增
					for (int i = lcolumn; i <= rcolumn; i++) {

						// System.out.println(lrow + " " + i);
						list.add(matrix[lrow][i]);
					}
					lrow = lrow + 1;
				} else if (status == 1) {
					// 列不动 行增
					for (int i = lrow; i <= rrow; i++) {
						// System.out.println(i + " " + rcolumn);
						list.add(matrix[i][rcolumn]);
					}
					rcolumn = rcolumn - 1;

				} else if (status == 2) {
					// 行不动 列减
					for (int i = rcolumn; i >= lcolumn; i--) {
						// System.out.println(rrow + " " + i);
						list.add(matrix[rrow][i]);
					}
					rrow = rrow - 1;
				} else if (status == 3) {
					// 列不动 行减
					for (int i = rrow; i >= lrow; i--) {
						// System.out.println(i + " " + lcolumn);
						list.add(matrix[i][lcolumn]);
					}
					lcolumn = lcolumn + 1;
				}
				status++;
			}
			// System.out.println(lrow + "--" + rrow + "---" + lcolumn + "--" +
			// rcolumn);
			return list;
		}
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (k > input.length) {
			return new ArrayList<Integer>();
		} else {
			Arrays.sort(input);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < k; i++) {
				list.add(input[i]);
			}
			return list;
		}
	}

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array.length == 0) {
			return 0;
		} else {
			Arrays.sort(array);
			// for (int e : array) {
			// System.out.print(e + " ");
			// }
			// System.out.println();
			int max = 1;
			int curnumber = array[0];
			int tempcount = 0;
			int target = array[0];
			for (int i = 0; i < array.length; i++) {
				if (array[i] != curnumber || i == array.length - 1) {
					// System.out.println("gaibian");
					if (tempcount > max) {
						// System.out.println("bijiaoda");
						// System.out.println(tempcount + "--" + max);
						max = tempcount;
						target = curnumber;
					}
					curnumber = array[i];
					tempcount = 1;
					// System.out.println(curnumber);
				} else {

					tempcount++;
					// System.out.println(curnumber + "jishu" + tempcount);
				}
			}
			// System.out.println(max + " " + Math.);
			if ((double) max > (double) (array.length / 2)) {
				return target;
			} else {
				return 0;
			}
		}
	}

	// 从上到下，从左到右打印
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		} else {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			s1.push(root);
			// 右节点优先压入
			///System.out.println("laiba");
			while (!s1.isEmpty() || !s2.isEmpty()) {
				//System.out.println("循环起来");
				// s2弹出来的每一个节点，把左右孩子放进去
				while (!s1.isEmpty()) {
					// 清空探入到s2
					s2.push(s1.pop());
				}

				while (!s2.isEmpty()) {
					// 每一个弹出来的节点的左右孩子push到s1中
					TreeNode node = s2.pop();
					list.add(node.val);
					if (node.left != null) {
						s1.push(node.left);
					}
					if (node.right != null) {
						s1.push(node.right);
					}
				}
			}
			return list;
		}
	}

	public void gogo() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		//t1.right = t3;
		ArrayList<Integer> list = PrintFromTopToBottom(t1);
		System.out.println(list.size());
		for (int e : list) {
			System.out.print(e + " ");
		}
	}

	public static void main(String[] args) {
		// int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		// int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		reBuildTree rb = new reBuildTree();
		// // rb.output(rb.reConstructBinaryTree(pre, in));
		// // System.out.println(rb.Fibonacci(39));
		// // System.out.println(rb.JumpFloorII(3));
		// // String S = null;
		// // System.out.println(rb.ReverseSentence(S));
		// // int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {
		// // 13, 14, 15, 16 } };
		// // int[][] a = { { 1, 2 } };
		// int[] b = { 4, 5, 1, 6, 2, 7, 3, 8 };
		// int[] c = { 1 };
		// // ArrayList<Integer> list = rb.printMatrix(a);
		// // ArrayList<Integer> list = rb.GetLeastNumbers_Solution(b, 4);
		// // for (int e : list) {
		// // System.out.print(e + " ");
		// // }
		// System.out.println(rb.MoreThanHalfNum_Solution(c));
		rb.gogo();
	}

}
