package Array;

/**
 * 求出数组中的反序对个数 {1,5,3,2,6} 把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
 * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；
 * 则前面数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i。
 **/

public class Inverted_pair {
	public int InversePairs(int[] array) {
		if (array == null)
			return 0;
		return mSort(array, 0, array.length - 1) % 1000000007;
	}

	public int mSort(int[] arr, int left, int right) {
		if (left >= right)
			return 0;
		int mid = (left + right) / 2;

		int leftcnt = mSort(arr, left, mid) % 1000000007; // 递归排序左边
		int rightcnt = mSort(arr, mid + 1, right) % 1000000007; // 递归排序右边
		int cnt = merge(arr, left, mid, right) % 1000000007; // 合并
		return (leftcnt + rightcnt + cnt) % 1000000007;
	}

	public int merge(int[] arr, int left, int mid, int right) {
		// [left, mid] [mid+1, right]
		int[] temp = new int[right - left + 1]; // 中间数组

		int i = mid;
		int j = right;
		int k = right - left;
		int cnt = 0;
		while (i >= left && j > mid) {
			if (arr[i] <= arr[j]) {
				temp[k--] = arr[j--];
			} else {
				temp[k--] = arr[i--];
				cnt += j - mid;
				if (cnt >= 1000000007) {
					cnt %= 1000000007;
				}
			}
		}

		while (i >= left) {
			temp[k--] = arr[i--];
		}

		while (j > mid) {
			temp[k--] = arr[j--];
		}

		for (int p = 0; p < temp.length; p++) {
			arr[left + p] = temp[p];
		}
		return cnt;
	}

}
