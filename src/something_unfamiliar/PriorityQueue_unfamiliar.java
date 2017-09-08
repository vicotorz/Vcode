package something_unfamiliar;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueue_unfamiliar {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(50);
		queue.add(3);
		for (int i = 0; i < 4; i++) {
			System.out.print(queue.poll() + ",");
		}

		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
