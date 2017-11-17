package ZOffer;

public class BeyondAHalf {

	public static int Ahalf(int[] num, int low, int high, int tarloc) {
		int i = low;
		int j = high;
		int val = num[i];
		while (i < j) {
			for (; i < j; j--) {
				if (num[j] < val)
					break;
			}
			num[i] = num[j];
			for (; i < j; i++) {
				if (num[i] > val)
					break;
			}
			num[j] = num[i];
		}
		num[i] = val;
		if (i == tarloc) {
			return num[i];
		} else if (i < tarloc) {
			return Ahalf(num, i + 1, high, tarloc);
		} else if (i > tarloc) {
			return Ahalf(num, low, i - 1, tarloc);
		}
		return val;
	}

	public static void main(String[] args) {
		int[] num = { 5, 4, 3, 5, 2, 1 ,7};
		System.out.println(Ahalf(num, 0, num.length - 1, (num.length - 1) / 2));
	}

}
