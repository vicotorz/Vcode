package SequeceList;
public class testList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SequnceList list = new SequnceList();

		list.add(1);
		list.add(2);
		list.add("sad");
		list.showall();

		/*
		 * list.clear(); list.showall();
		 */

		/*
		 * list.delete(1); list.showall();
		 */
		int size = list.getSize();
		System.out.println(size);

		Object element = list.getFirstElement();
		System.out.println(element);

		Object ele = list.getSpecificElement(2);
		System.out.println(ele);

		Object index = list.getIndex("sad");
		System.out.println(index);

		list.deltelast();
		list.showall();

		boolean flag = list.isempty();
		System.out.println(flag);

		list.insert(1, "new");
		list.showall();

		list.delete(0);
		list.showall();
	}
}
