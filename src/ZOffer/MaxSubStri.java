
public class MaxSubStri {
	public static int findLongest(int[] A, int n) {
		// write code here
		int length = n;
		int[] number = new int[length];
		number[0] = 1;
		for (int i = 0; i < length; i++) {
			int max = 0;
			for (int j = i; j >= 0; j--) {
				if (A[i] > A[j] && number[j] > max) {
					max = number[j];
				}
			}
			number[i] = max + 1;
		}
		int max = number[0];
		for (int t = 0; t < length; t++) {
			if (number[t] > max) {
				max = number[t];
			}
		}
		for (int e : number) {
			System.out.print(e + ",");
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 46, 200, 83, 24, 211, 86, 61, 67 };
		int n = 8;
		System.out.println(findLongest(A, n));
	}

}
