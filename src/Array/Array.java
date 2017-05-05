package Array;

import java.util.Arrays;

/**
 * 递归输出数组倒序（突发奇想）
 */
public class Array {
	public void printReverse(int[] array, int size) {
		if (size == 1) {
			System.out.print(array[size - 1] + "[end]");
			return;
		} else {
			// 输出最后一个数 和前面数组的最后一个数
			System.out.print(array[size - 1] + "--");
			int[] temparray = Arrays.copyOfRange(array, 0, size - 1);
			printReverse(temparray, size - 1);
		}
	}

	public static void main(String[] args) {
		int[] t = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Array a = new Array();
		a.printReverse(t, 9);
		// System.out.println(Arrays.binarySearch(t, -1));
		// int[] g = Arrays.copyOfRange(t, 0, 2);
		// for (int e : g) {
		// System.out.print(e);
		// }
		int[] in = { 4, 7, 0 };
		System.out.println(Arrays.binarySearch(in, 0));
	}

}
