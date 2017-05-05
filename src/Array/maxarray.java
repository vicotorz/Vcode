package Array;

/**
 * 2017-3-29 利用动态规划求解数组里面的最大子数组和
 * 
 * End[i]=max(End[i-1]+arr[i],arr[i])
 * */
public class maxarray {

	public void getmax(int[] arr) {
		int size = arr.length;
		int[] End = new int[size];
		End[0] = arr[0];
		for (int i = 1; i < size; i++) {
			End[i] = End[i - 1] + arr[i] > arr[i] ? End[i - 1] + arr[i]
					: arr[i];
		}
		for (int i = 0; i < size; i++) {
			System.out.print(End[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, -2, 4, 8, -4, 7, -1, -5 };
		new maxarray().getmax(arr);
	}

}
