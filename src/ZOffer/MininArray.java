package ZOffer;

public class MininArray {
	public static int minNumberInRotateArray(int[] array) {
		int low = 0;
		int high = array.length - 1;

		int med = (low + high) / 2;
		int targetNum = Integer.MAX_VALUE;
		while (low < high) {
			if (array[low] < array[high]) {
				targetNum = array[low];
				break;
			}
			if (array[low] == array[high]) {
				for (int t = low; t <= high; t++) {
					if (targetNum > array[t]) {
						targetNum = array[t];
					}
				}
				break;
			}
			if (array[med] > array[low] && array[med] > array[high]) {
				low = med + 1;
			} else if (array[med] < array[low] && array[med] < array[high]) {
				high = med - 1;
			}

			med = (low + high) / 2;
		}
		return targetNum;

	}

	public static void main(String[] args) {
		int[] num = { 1, 1, 1, 0, 1 };
		System.out.println(minNumberInRotateArray(num));
	}
}
