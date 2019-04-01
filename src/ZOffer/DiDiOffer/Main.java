package DiDiOffer;

import java.util.Scanner;

//[2,2] 因为 2 ^ 2 == 0 所以 区间 + 1
//[0] 直接 区间 + 1
//如果是 [2, 2, 3] 因为 2 ^ 2 ^ 3 != 0 所以不算区间
public class Main {
	public static boolean check(int[] num, int n, int left, int right) {
		// System.out.println(left + "," + right);
		int result = num[left];
		for (int i = left + 1; i <= right; i++) {
			result = result ^ num[i];
		}
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int fun(int[] num, int n) {
		if (n <= 0) {
			return 0;
		}
		int result = 0;
		int preright;
		for (int i = 0; i < n; i++) {
			preright = Integer.MIN_VALUE;
			int tempresult = 0;
			int left = i;
			for (int j = left; j < n; j++) {
				int right = j;
				if (right <= n - 1 && left <= right && left > preright && check(num, n, left, right)) {
					tempresult++;
					preright = right;
					left = right + 1;
				}
			}
			result = Math.max(result, tempresult);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			String[] str = sc.nextLine().split(" ");
			int[] num = new int[n];
			for (int i = 0; i < str.length; i++) {
				num[i] = Integer.valueOf(str[i]);
			}
			System.out.println(fun(num, n));
		}
		sc.close();

	}

}
