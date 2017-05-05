package Sort;

import java.util.Arrays;

// 归并排序

public class mergeSort {
	int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	public mergeSort() {
		sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

	public void sort(int[] data, int left, int right) {
		// TODO Auto-generated method stub
		System.out.println("sort数组【范围】左" + left + "【范围】右" + right);
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2; // 对左边数组进行递归
			sort(data, left, center); // 对右边数组进行递归
			sort(data, center + 1, right); // 合并
			merge(data, left, center, right);
		}
	}

	public void merge(int[] data, int left, int center, int right) {
		// TODO Auto-generated method stub
		System.out.println("合并数组【范围】左" + left + " 【范围】中 " + center + " 【范围】右"
				+ right);
		int[] tmpArr = new int[data.length];
		int mid = center + 1; // third记录中间数组的索引
		int third = left;
		int tmp = left;
		while (left <= center && mid <= right) {
			/**
			 * 不是自己的编程风格，所以读代码有点吃力
			 * */
			// 从两个数组中取出最小的放入中间数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		// 剩余部分依次放入中间数组
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		// 将中间数组中的内容复制回原数组
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		new mergeSort();
	}

}
