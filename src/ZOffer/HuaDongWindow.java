package ZOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HuaDongWindow {
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (size == 0||size>num.length) {
			return new ArrayList();
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int max = 0;
		for (int t = 0; t < size; t++) {
			max = Math.max(max, num[t]);
			queue.add(num[t]);
		}
		result.add(max);

		for (int i = size; i < num.length; i++) {
			int throwNum = queue.poll();
			if (throwNum == max) {
				int tempmax = num[i];
				for (int t = i; t >= i - size + 1; t--) {
					if (num[t] > tempmax) {
						tempmax = num[t];
					}
				}
				max = tempmax;
			}
			max = Math.max(max, num[i]);
			queue.add(num[i]);
			result.add(max);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		ArrayList list = maxInWindows(num, 3);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ",");
		}
	}
}
