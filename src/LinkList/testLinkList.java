package LinkList;
public class testLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList list = new LinkList();

		list.add("123");
		list.add("789");
		list.add("12344");
		list.add("7");
		list.add("789~~");
		// list.deletespecic(1);
		// list.insertfirst("test");
		// list.clear();
		// System.out.println(list.getlocation("123"));
		// System.out.println(list.getSize());
		// System.out.println(list.getlastNode().data);
		// list.clear();

		// System.out.println(list.getSize());
		// System.out.println(list.getKlocation(1).data);
		list.showall();
		System.out.println("---开始移动------");
		list.leftmove(3);
		list.showall();
	}

}
