package WanMeiShijie;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	// 维持两个两个栈，一个放最大值，一个放最小值
	public static void fun(int n, int[] num) {
		if (n <= 1) {
			System.out.println(0 + "," + 0);
			return;
		}
		Stack<Integer> maxStack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			int target = num[i];
			stack.push(target);

			// 放入最大值到最大栈
			if (maxStack.isEmpty() || target >= maxStack.peek()) {
				maxStack.push(target);
			} else if (target < maxStack.peek()) {
				maxStack.push(maxStack.peek());
			}
			// 放入最小值到最小栈
			if (minStack.isEmpty() || target <= minStack.peek()) {
				minStack.push(target);
			} else if (target > minStack.peek()) {
				minStack.push(minStack.peek());
			}

		}
		stack.pop();
		maxStack.pop();
		minStack.pop();
		int finmax = maxStack.pop();
		int finmin = minStack.pop();
		System.out.println(finmax + "," + finmin);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int n = Integer.valueOf(str[0]);
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = Integer.valueOf(str[i + 1]);
			}
			fun(n, num);
		}
		sc.close();

	}

}
