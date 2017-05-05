package Sort;

import java.util.ArrayList;
import java.util.Arrays;

import Sort.heapSort.ListNode;

public class InsertionSort {
	public int[] insertionSort(int[] A, int n) {
		// write code here
		// i元素插入到之前的数组中
		for (int i = 0; i < n; i++) {
			// 插入A[i]到0-i的数组中
			int target = A[i];
			for (int j = 0; j <= i - 1; j++) {
				if (A[j] > A[i]) {
					// j+1~i-1统一向后移
					// A[j]=A[i]
					for (int t = i; t > j; t--) {
						A[t] = A[t - 1];
					}
					A[j] = target;
					for (int e : A) {
						System.out.print(e + " ");
					}
					System.out.println();
					break;
				}
			}
		}
		return A;
	}

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

	public int[] quickSort(int[] A, int n) {
		qsort_asc(A, 0, n - 1);
		return A;
	}

	private void qsort_asc(int data[], int low, int high) {
		int i, j, x;
		if (low < high) { // 这个条件用来结束递归
			i = low;
			j = high;
			x = data[i];
			while (i < j) {
				while (i < j && data[j] > x) {
					j--; // 从右向左找第一个小于x的数
				}
				if (i < j) {
					data[i] = data[j];
					i++;
				}
				while (i < j && data[i] < x) {
					i++; // 从左向右找第一个大于x的数
				}
				if (i < j) {
					data[j] = data[i];
					j--;
				}
			}
			data[i] = x;
			qsort_asc(data, low, i - 1);
			qsort_asc(data, i + 1, high);
		}
	}

	// 堆排序的精髓--重建堆
	public int[] Rebuild(int[] A, int n) {
		// 一旦移动，重头检查
		// 检查A[i]与A[2*i+1],A[2*i+2]
		// 主循环一共循环A.length/2次就行
		for (int i = 0; i < n / 2;) {
			if (2 * i + 1 <= n - 1 && A[i] < A[2 * i + 1]) {
				int temp = A[2 * i + 1];
				A[2 * i + 1] = A[i];
				A[i] = temp;
				i = 0;
				// 回去重排序
				continue;
			} else if (2 * i + 2 <= n - 1 && A[i] < A[2 * i + 2]) {
				int temp = A[2 * i + 2];
				A[2 * i + 2] = A[i];
				A[i] = temp;
				i = 0;
				// 回去重排序
				continue;
			} else {
				i++;
			}
		}
		return A;
	}

	public int[] heapSort(int[] A, int n) {
		// write code here
		for (int j = n - 1; j >= 0; j--) {
			A = Rebuild(A, j + 1);
			// 第一个和最后一个交换
			int temp = A[0];
			A[0] = A[j];
			A[j] = temp;
		}
		return A;
	}

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(head.val);
		ListNode node = head.next;
		while (node != null) {
			list.add(node.val);
			node = node.next;
		}
		Object[] array = list.toArray();
		int[] arr = new int[array.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(String.valueOf(array[i]));
		}
		arr = heapSort(arr, arr.length);
		head.val = (arr[0]);
		node = head.next;
		int index = 1;
		while (node != null) {
			node.val = arr[index];
			node = node.next;
			index++;
		}
		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void dd() {
		ListNode node = new ListNode(1);
		sortList(node);
	}

	// 希尔排序重要的确定步长
	public int[] shellSort(int[] A, int n) {
		// write code here
		int step = n / 2;
		int loc = (n - 1) / 2;
		while (step >= 1) {
			System.out.println("step" + step + "loc" + loc);
			for (int i = 0; i <= loc; i++) {
				for (int t = i + step; t < A.length; t += step) {
					System.out.println(t + " " + step);
					// 直接插入排序
					// i元素插入到之前的数组中
					int j = t - step;
					int temp = A[t];
					for (; j >= 0 && temp < A[j]; j -= step) {
						A[j + step] = A[j];// 一直往前倒腾地方，一旦temp>a[j]就到地方了
					}
					// 这个时候开始换
					A[j + step] = temp;
					// 如果 a[i-d](a[j])>a[i] 这两个值互换
					// t = t + step;
				}
			}
			for (int e : A) {
				System.out.print(e + " ");
			}
			System.out.println();
			step = step / 2;
			loc = loc / 2;
		}
		return A;
	}

	// 计数排序
	public int[] countingSort(int[] A, int n) {
		// 得先知道最大值是谁...
		int max = A[0];
		for (int i = 0; i < n; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		// write code here
		int[] bucket = new int[max + 1];
		Arrays.fill(bucket, 0);
		for (int i = 0; i < A.length; i++) {
			bucket[A[i]]++;
		}
		// 重新构建数组
		int index = 0;
		for (int j = 0; j < bucket.length; j++) {
			// System.out.println("桶" + j + "数目" + bucket[j]);
			if (bucket[j] > 1) {
				while (bucket[j] > 0) {
					A[index] = j;
					bucket[j]--;
					index++;
				}
			} else if (bucket[j] == 1) {
				A[index] = j;
				index++;
			}
		}
		return A;
	}

	public int[] radixSort(int[] A, int n) {
		int[][] bucket = new int[10][n];
		int base = 1;// 基数
		int position = 1;// 个位、十位、百位
		while (position <= 3) {
			int[] count = new int[10];// 第几桶中元素个数
			for (int i : A) {// 装桶
				bucket[(i / base) % 10][count[(i / base) % 10]++] = i;
			}
			int index = 0;
			for (int i = 0; i < 10; i++) {// 倒桶
				for (int j = 0; j < count[i]; j++) {
					A[index++] = bucket[i][j];
				}
			}
			base *= 10;
			position++;
		}
		return A;
	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		is.dd();
		// int[] A = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		// // int[] A = { 4, 5, 3, 0, 1, 7, 2, 6 };
		// int n = 13;
		// // int[] A = { 1, 2, 3, 5, 2, 3 };
		// // int n = 6;
		// // is.insertionSort(A, n);
		// // is.divide(A, n);
		// // is.quickSort(A, n);
		// // is.Rebuild(A);
		// // is.heapSort(A, n);
		// // is.shellSort(A, n);
		// // is.countingSort(A, n);
		// is.radixSort(A, n);
		// for (int e : A) {
		// System.out.print(e + " ");
		// }
	}
}