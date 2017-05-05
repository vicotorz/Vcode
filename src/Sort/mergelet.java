package Sort;

/**
 * 对两个有序数组进行合并 2017-3-29 原创代码
 */
public class mergelet {
	public void merge(int[] a, int[] b) {
		int s1 = a.length - 1;
		int s2 = b.length - 1;
		int ia = 0;
		int ib = 0;
		int iend = 0;
		int[] fin = new int[a.length + b.length];
		int value_a = a[0], value_b = b[0];
		while (true) {
			System.out.println(ia + "--" + ib);
			if ((ia == a.length) && (ib == b.length)) {
				break;
			}

			System.out.println(value_a + "-vs-" + value_b);
			if (ia <= s1 && ib <= s2) {
				System.out.println("【1】");
				value_a = a[ia];
				value_b = b[ib];
				if (value_a <= value_b) {
					fin[iend++] = value_a;
					ia++;
				} else {
					fin[iend++] = value_b;
					ib++;
				}
			} else if (ia <= s1) {
				System.out.println("【2】");
				fin[iend++] = a[ia++];
			} else if (ib <= s2) {
				System.out.println("【3】");
				fin[iend++] = b[ib++];
			}
		}
		for (int v : fin) {
			System.out.print(v + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[] a = { 54 };
		int[] b = { 35, 48 };
		mergelet m = new mergelet();
		m.merge(a, b);
	}

}
