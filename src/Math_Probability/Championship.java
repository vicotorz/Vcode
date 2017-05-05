package Math_Probability;

public class Championship {
	public int[] calc(int k) {
		// write code here
		int[] res = new int[2];
		int total = 1;
		for (int i = 2 * k - 1; i > 1; i -= 2)
			total *= i;
		int notMeet = (k + 1) * k / 2;
		for (int i = 2; i < k; i++)
			notMeet *= i;
		int meet = total - notMeet;
		int tmp = gcd(meet, total);
		System.out.println(meet + "--" + total);
		res[0] = meet / tmp;
		res[1] = total / tmp;
		return res;

	}

	private int gcd(int m, int n) {
		while (n != 0) {
			int tmp = n;
			n = m % n;
			m = tmp;
		}
		return m;
	}

	public static void main(String[] args) {
		int[] r = new Championship().calc(5);
		System.out.println(r[0] + " " + r[1]);
	}
}
