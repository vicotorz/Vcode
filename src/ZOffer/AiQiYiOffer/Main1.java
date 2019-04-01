package AiQiYiOffer;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

	public static void fun(String bracket) {
		if (bracket.equals("") || bracket == null) {
			System.out.println(0);
			return;
		}
		Stack<String> stack = new Stack<String>();
		int count = 0;
		int tempcount = 0;

		int left = 0;
		for (int i = 0; i < bracket.length(); i++) {
			if (stack.isEmpty() || (left != 0 && String.valueOf(bracket.charAt(i)).equals("("))) {
				count = Math.max(count, tempcount);
				tempcount = 0;
			}
			if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")")) {
				stack.pop();
			}
			if (String.valueOf(bracket.charAt(i)).equals(")")) {
				stack.pop();
				tempcount++;
				left--;
			} else {
				stack.push(String.valueOf(bracket.charAt(i)));
				left++;
			}
		}
		count = Math.max(count, tempcount);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String bracket = sc.nextLine().trim();
			fun(bracket);
		}
		sc.close();
	}

}
