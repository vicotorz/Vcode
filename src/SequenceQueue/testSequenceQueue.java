package SequenceQueue;
public class testSequenceQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceQueue que = new SequenceQueue();
		que.showall();
		que.add("ZHANG");
		que.add("vic");
		que.add("I love you");
		que.showall();

		que.peak();
		que.isEmpty();
		que.remove();
		que.showall();
		que.add("test");
		que.showall();

		int i = que.getSize();
		System.out.println("所获得的size的值为" + i);
		que.clear();
		que.showall();

	}

}
