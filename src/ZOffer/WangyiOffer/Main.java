package WangyiOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	// 最长公共子序列长度
	public static int findLCS(String A, int n, String B, int m) {
		// 行对应A，比A长1，原因是0作为初始化。列同理。dp[n][m]指A[n-1],B[m-1]
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		// 事实上，数组默认也是0
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// 如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
				if (A.charAt(i - 1) == B.charAt(j - 1)) {// A[0]==B[0],对应dp[1][1]
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[n][m];
	}

	//
	public static void dfs(ArrayList<String> res, String item, int left, int right) {
		if (left > right)// deal wiith ")("
			return;

		if (left == 0 && right == 0) {
			res.add(new String(item));
			return;
		}

		if (left > 0)
			dfs(res, item + '(', left - 1, right);
		if (right > 0)
			dfs(res, item + ')', left, right - 1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String bracket = sc.nextLine();
			if (bracket.equals(" ")) {
				System.out.println(0);
			} else {
				int n = 0;
				for (int i = 0; i < bracket.length(); i++) {
					// 统计左括号长度
					if (bracket.charAt(i) == '(') {
						n++;
					}
				}

				ArrayList<String> res = new ArrayList<String>();
				String items = new String();

				dfs(res, items, n, n);

				Iterator it = res.iterator();

				PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
				HashMap<Integer, Integer> map = new HashMap();
				while (it.hasNext()) {
					String temp = (String) it.next();
					if (!temp.equals(bracket)) {
						System.out.println(temp);
						int value = findLCS(bracket, bracket.length(), temp, temp.length());
						// System.out.println(value + "," +
						// map.containsKey(value));
						if (map.containsKey(value)) {
							int prevalue = map.get(value);
							map.put(value, prevalue + 1);
						} else {
							map.put(value, 1);
						}
						queue.add(value);
					}
				}
				for (int i = 0; i < queue.size() - 2; i++) {
					queue.poll();
				}
				if (queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(map.get(queue.poll()));
				}
			}
		}
		sc.close();

	}

}
