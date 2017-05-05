package Test;

public class ntest {
	public static void main(String[] args) {
		double s = 0.0;
		int k = 10;
		while (k <= 10) {
			int t = k;
			double b = 1.0;
			while (t >= 1) {
				b = b * (double) (1 / t);
				t = t - 1;
			}
			k = k - 1;
			s = s + b;
		}

		System.out.print(s);
	}

}
