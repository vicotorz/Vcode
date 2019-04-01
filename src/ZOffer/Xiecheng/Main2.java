package Xiecheng;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
	private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(15, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	int count = 0;

	public void Insert(Integer num) {
		count++;
		if ((count & 1) == 0) {
			if (!maxQueue.isEmpty() && num < maxQueue.peek()) {
				maxQueue.offer(num);
				num = maxQueue.poll();
			}
			minQueue.offer(num);
		} else {
			if (!minQueue.isEmpty() && num > minQueue.peek()) {
				minQueue.offer(num);
				num = minQueue.poll();
			}
			maxQueue.offer(num);
		}
	}

	public Double GetMedian() {
		if ((count & 1) == 0)
			return ((double) (maxQueue.peek() + minQueue.peek())) / 2;
		else
			return (double) maxQueue.peek();
	}

	public double fun(int n, int[] num, int m, int[] nu) {
		for (int i = 0; i < num.length; i++) {
			Insert(num[i]);
		}
		for (int j = 0; j < nu.length; j++) {
			Insert(nu[j]);
		}

		return GetMedian();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.valueOf(str[i]);
		}

		int m = Integer.valueOf(sc.nextLine());
		String[] st = sc.nextLine().split(" ");
		int[] nu = new int[m];
		for (int i = 0; i < m; i++) {
			nu[i] = Integer.valueOf(st[i]);
		}

		System.out.println(new Main2().fun(n, num, m, nu));
	}
}
