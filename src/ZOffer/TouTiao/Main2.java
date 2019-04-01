package TouTiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	public static void func(int[] num, int n) {
		Queue queue = new LinkedList<String>();
		// 放进去
		int min = Integer.MAX_VALUE;
		int nextmin = 0;
		int sum = 0;
		int result1 = 0;
		// 弹出首
		int min2 = Integer.MAX_VALUE;
		int sum2 = 0;
		int result2 = 0;
		int MAX = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (num[i] < min) {
				nextmin = min;
				min = num[i];
				if (i == 0) {
					nextmin = min;
				}
			}
			sum = sum + num[i];
			result1 = min * sum;
			queue.add(num[i]);
			if (result1 > MAX) {
				MAX = result1;
			}

			if (queue.size() >= 2) {
				int first = (int) queue.peek();
				sum2 = sum - first;
				if (min == first) {
					System.out.println("nextmin");
					min2 = nextmin;
				} else {
					System.out.println("tihuan");
					min2 = min;
				}
				System.out.println("[sum2]" + sum2 + "[min2]" + min2);
				result2 = sum2 * min2;
				if (result2 > result1) {
					queue.poll();
					min = min2;
					sum = sum2;
					System.out.println("[result2]" + result2);
					if (result2 > MAX && result2 < 2147483635) {
						MAX = result2;
					}
				}
			}
			for (Object e : queue.toArray()) {
				System.out.print(e + ",");
			}
			System.out.println();
			System.out.println(MAX);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] str = line.split(" ");
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = Integer.valueOf(str[i]);
			}
			func(num, n);
		}
		sc.close();
	}
}
