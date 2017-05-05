package Array;

import java.util.Arrays;
import java.util.List;

public class Array2List {

	/**
	 * Arrays.asList方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 4 };
		List<int[]> list = Arrays.asList(a, b);
		System.out.println(list.get(0));
		System.out.println(list.size());
	}

}
