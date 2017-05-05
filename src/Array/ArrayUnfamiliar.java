package Array;

import java.util.Arrays;

public class ArrayUnfamiliar {

	/**
	 * 使用Arrays.fill进行数组填充
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		Arrays.fill(a, -1);// 用同一个值填充
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		int[] b = new int[3];
		b = Arrays.copyOfRange(a, 1, 3);
		for (int t : b) {
			System.out.println(t);
		}
	}

}
