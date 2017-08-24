package ZOffer;

public class TwoDouble {
	// 训练递归操作 exponent有负数的情况
	public static double Power(double base, int exponent) {
		if (exponent == 0) {
			return 1.0;
		}
		if (exponent == 1) {
			return base;
		}
		if (exponent == -1) {
			return 1 / base;
		}
		int flag = exponent > 0 ? 1 : -1;
		if (exponent % 2 == 0) {
			return Power(base, exponent / 2) * Power(base, exponent / 2);
		} else {
			return Power(base, exponent / 2) * Power(base, (exponent + 1 * (flag)) / 2);
		}
	}

	public static void main(String[] args) {
		System.out.println(Power(2, -3));
	}
}
