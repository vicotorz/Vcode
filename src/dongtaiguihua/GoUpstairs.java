package dongtaiguihua;

public class GoUpstairs {
	public int countWays(int n) {
		// write code here
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			int temp1 = 2;
			int temp2 = 1;
			int sum = 0;
			for (int i = 3; i <= n; i++) {
				System.out.println(temp1 + "--" + temp2);
				sum = (temp1 + temp2) % 1000000007;
				temp2 = temp1;
				temp1 = sum;

			}
			return sum;
		}
	}

	public static void main(String[] args) {
		GoUpstairs g = new GoUpstairs();
		System.out.println(g.countWays(36196));
	}
}