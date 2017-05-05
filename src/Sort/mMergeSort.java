package Sort;

import java.util.Arrays;

public class mMergeSort {
	public int[] divide(int[] A, int n) {
		// write code here
		// 利用迭代进行数组划分
		// for (int e : A) {
		// System.out.print(e + "##");
		// }
		// System.out.println();
		int center = n / 2;
		if (center > 0) {
			// System.out.println("【center】" + center);
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
		// System.out.println("【进来的两个数组】");
		// for (int e : a) {
		// System.out.print(e + " ");
		// }
		// System.out.println();
		// for (int e : b) {
		// System.out.print(e + " ");
		// }
		// System.out.println();
		int s1 = a.length - 1;
		int s2 = b.length - 1;
		int ia = 0;
		int ib = 0;
		int iend = 0;
		int value_a = a[0], value_b = b[0];
		while (true) {
			// System.out.println("【位置信息】" + ia + "--" + ib);
			if ((ia == a.length) && (ib == b.length)) {
				break;
			}

			// System.out.println(value_a + "-vs-" + value_b);
			if (ia <= s1 && ib <= s2) {
				// System.out.println("【1】");
				value_a = a[ia];
				value_b = b[ib];
				if (value_a <= value_b) {
					// System.out.println(iend + "处添加" + value_a);
					A[iend++] = value_a;
					ia++;
				} else {
					// System.out.println(iend + "处添加" + value_b);
					A[iend++] = value_b;
					ib++;
				}
			} else if (ia <= s1) {
				// System.out.println("【2】");
				// System.out.println(iend + "处添加" + a[ia]);
				A[iend++] = a[ia++];
			} else if (ib <= s2) {
				// System.out.println("【3】");
				// System.out.println(iend + "处添加" + b[ib]);
				A[iend++] = b[ib++];
			}
		}
		// System.out.println("【归并结果】");
		// for (int v : A) {
		// System.out.print(v + " ");
		// }
		// System.out.println();
		// return fin;
	}
}
