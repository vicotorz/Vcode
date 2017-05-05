package HuffmanTree;
import java.util.ArrayList;

public class testlist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.remove(0);
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.println(list.get(i));
		}

	}
}
