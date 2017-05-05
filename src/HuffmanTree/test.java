package HuffmanTree;
import java.util.ArrayList;
import java.util.List;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmanTree tree = new HuffmanTree();
		List<HuffmanTree.Node> list = new ArrayList<HuffmanTree.Node>();
		list.add(tree.new Node("A", 40));
		list.add(tree.new Node("B", 7));
		list.add(tree.new Node("C", 10));
		list.add(tree.new Node("D", 30));
		list.add(tree.new Node("E", 12));
		list.add(tree.new Node("F", 2));
		HuffmanTree.Node root = tree.createTree(list);
		tree.showall(root);

	}
}
