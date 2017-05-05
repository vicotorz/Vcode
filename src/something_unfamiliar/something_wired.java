package something_unfamiliar;

public class something_wired {
	// 传递的是引用
	public void change(int[] a) {
		// 交换0，2位置的数值
		int temp = a[2];
		a[2] = a[0];
		a[0] = temp;
	}

	public static void main(String[] args) {
		something_wired sw = new something_wired();
		int[] a = { 1, 2, 3 };
		sw.change(a);
		for (int t : a) {
			System.out.print(t + " ");
		}
	}

}
