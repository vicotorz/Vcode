package treedemo;

public class testtree {

	/**
	 * 测试树代码
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		treemodel tree = new treemodel("root");
		// System.out.println(tree.isEmpty());
		/*
		 * tree.add("test", tree.getRoot()); tree.add("vic", tree.getRoot());
		 * tree.add("OK", tree.find2(2)); // tree.update(2, "modified");
		 * System.out.println("树的信息为："); // 先跟顺序输出的节点的信息
		 * tree.showall(tree.getRoot());
		 */

		/*
		 * System.out.println("树的高为："+tree.getHeight());
		 * System.out.println("树的节点个数："+tree.getNodenum());
		 * 
		 * System.out.println("要删除的节点是"+tree.find2(1).data);
		 * System.out.println("----删除后-----"); tree.delete(tree.find2(1));
		 * tree.showall(tree.getRoot());
		 */
		Object pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' };
		Object in[] = { 'D', 'B', 'E', 'A', 'F', 'C' };
		tree.setRoot(tree.establishtree(pre, in, 0, 5, 0, 5));
		System.out.println("+++++++++++++++++++");
		tree.specialsearch(tree.getRoot());
		System.out.println("+++++++++++++++++++");

		/* tree.specialsearch(tree.getRoot()); */

	}
}
