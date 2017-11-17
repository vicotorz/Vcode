package ZOffer;

public class ChangeArray {
	public static void reOrderArray(int[] array) {
		int i = 0;
		int j = array.length - 1;
		// 奇数+偶数
		while (j >= i) {
			for (;; i++) {
				if (i % 2 != 0)
					break;
			}

			for (;; j--) {
				if (j % 2 == 0)
					break;
			}
			System.out.println(i + "," + j);
			// 交换

			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			i++;
			j--;
		}

		for (int e : array) {
			System.out.print(e + ",");
		}
	}

	public static void Another(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - 1; j++) {
				if (num[j] % 2 == 0 && num[j + 1] % 2 != 0) {
					int temp = num[j + 1];
					num[j + 1] = num[j];
					num[j] = temp;
				}
			}
		}
		for (int e : num) {
			System.out.print(e + ",");
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6, 7 };
		Another(num);
	}
}
