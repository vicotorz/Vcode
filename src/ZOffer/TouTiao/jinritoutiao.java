package TouTiao;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class jinritoutiao {
	public static int encoreNumber(int[] score, int n) {
		int[] r = score;
		Arrays.sort(r);
		HashMap indexmap = new HashMap<>();
		// 计算两个分数之间的差值
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			if (r[i + 1] - r[i] < 10) {
				if (indexmap.get(r[i]) == null) {
					sum += 1;
					indexmap.put(r[i], r[i]);
				}
				if (indexmap.get(r[i + 1]) == null) {
					sum += 1;
					indexmap.put(r[i + 1], r[i + 1]);
				}
				if (r[i + 1] == r[i]) {
					sum += 1;
				}
			}
		}

		int result = 0;
		for (int i = 0;; i++) {
			if (3 * i > sum) {
				result = 3 * i - sum;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine().trim());
		String[] str = sc.nextLine().split(" ");
		int[] score = new int[n];
		for (int i = 0; i < n; i++) {
			score[i] = Integer.valueOf(str[i]);
		}
		System.out.println(encoreNumber(score, n));
	}

}
