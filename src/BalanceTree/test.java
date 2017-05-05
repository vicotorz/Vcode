package BalanceTree;
import java.util.ArrayList;
import java.util.List;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BalanceTree tree = new BalanceTree();
		//访问内部类
		List<BalanceTree.Node> list = new ArrayList<BalanceTree.Node>();
		list.add(tree.new Node("1"));
		list.add(tree.new Node("2"));
		list.add(tree.new Node("3"));
		list.add(tree.new Node("4"));
		list.add(tree.new Node("5"));
		System.out.println("#####" + list.size());

		tree.showall(tree.CreateTree(list, 0, list.size() - 1));

	}
}
