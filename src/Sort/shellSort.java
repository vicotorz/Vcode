package Sort;

/**
 * shell排序
 * 
 * shell排序中每个子排序用到了插入排序
 * 
 * **/
// 希尔排序

public class shellSort {
	public shellSort() {
		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
		double d1 = a.length;
		int temp = 0;
		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			System.out.println("d:" + d);
			for (int x = 0; x < d; x++) {
				// shell排序中各个小排序，相当于插入排序
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];// 一直往前倒腾地方，一旦temp>a[j]就到地方了
					}
					// 这个时候开始换
					a[j + d] = temp;
					// 如果 a[i-d](a[j])>a[i] 这两个值互换

				}

			}
			// 如果步长为1，到头了
			if (d == 1)
				break;
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

	public static void main(String[] args) {
		new shellSort();
	}
}
