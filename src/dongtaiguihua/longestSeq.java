package dongtaiguihua;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。 [1,4,2,5,3],5
 * 
 * **/
public class longestSeq {
	public int getLIS(int[] A, int n) {
		// write code here
		if (n <= 0) {
			return 0;
		} else {
			int[] longseq = new int[n];
			longseq[0] = 1;
			for (int i = 1; i <= (n - 1); i++) {
				// 找0-(i-1) 里小于i longseq最大的
				int max = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (A[j] < A[i] && longseq[j] > max) {
						max = longseq[j];
					}
				}
				longseq[i] = max + 1;
			}
			int max = 0;
			for (int e : longseq) {
				if (e > max) {
					max = e;
				}
			}
			return max;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		System.out.println(arr.length);
		longestSeq l = new longestSeq();
		System.out.println(l.getLIS(arr, arr.length));
	}
}
