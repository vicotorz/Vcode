package Sort;

import java.util.Arrays;

public class mMergeSort {
	public static void main(String[] args) {
		mMergeSort m = new mMergeSort();
		int[] num = { 3, 2, 9, 1, 5 };
		int[] result = m.divide(num, num.length);
		for (int e : result) {
			System.out.print(e + ",");
		}

	}

	public int[] divide(int[] A, int n) {
		// write code here
		// 利用迭代进行数组划分
		int center = n / 2;
		if (center > 0) {
			int[] Aleft = Arrays.copyOfRange(A, 0, center);
			int[] Aright = Arrays.copyOfRange(A, center, A.length);
			// 搞不懂，递归结果根本没有改变
			divide(Aleft, Aleft.length);
			divide(Aright, Aright.length);
			merge(Aleft, Aright, A);// 必须把A带上(必须根着A，如果不跟A，迭代前后两次的数组不一样)

		}

		return A;
	}

	// 必须保证进来的两个数组有序
	public void merge(int[] a, int[] b, int[] A) {
		int s1 = a.length - 1;
		int s2 = b.length - 1;
		int ia = 0;
		int ib = 0;
		int iend = 0;
		int value_a = a[0], value_b = b[0];
		while (true) {
			if ((ia == a.length) && (ib == b.length)) {
				break;
			}
			if (ia <= s1 && ib <= s2) {
				value_a = a[ia];
				value_b = b[ib];
				if (value_a <= value_b) {
					A[iend++] = value_a;
					ia++;
				} else {
					A[iend++] = value_b;
					ib++;
				}
			} else if (ia <= s1) {
				A[iend++] = a[ia++];
			} else if (ib <= s2) {
				A[iend++] = b[ib++];
			}
		}
	}
}
