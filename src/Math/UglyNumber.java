package Math;

public class UglyNumber {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			int startnumber = 2;
			int count = 2;
			int target = 2;
			for (int i = startnumber; count <= index; i++) {
				if ((i % 7 != 0) && (i % 2 == 0 || i % 3 == 0 || i % 5 == 0)) {
					// if (i % 7 != 0) {
					// System.out.println(i);
					count = count + 1;
					target = i;
				}
			}
			return target;
		}
	}

	public int GetUglyNumber_Solution1(int index) {

		if (index <= 0)
			return 0;
		int[] result = new int[index];
		int count = 0;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		result[0] = 1;
		int tmp = 0;
		while (count < index - 1) {
			tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
			if (tmp == result[i2] * 2)
				i2++;// 三条if防止值是一样的，不要改成else的
			if (tmp == result[i3] * 3)
				i3++;
			if (tmp == result[i5] * 5)
				i5++;
			result[++count] = tmp;
		}
		return result[index - 1];
	}

	private int min(int a, int b) {
		return (a > b) ? b : a;
	}

	public static void main(String[] args) {
		UglyNumber u = new UglyNumber();
		System.out.println(u.GetUglyNumber_Solution1(1500));
	}
}
