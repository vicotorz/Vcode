package Array;

/***
 * 
 * 2017-3-29
 * 
 * 计算数组中数对之间差的最大值
 * 
 * 自顶向下分析 diff[i]记录0~i的最大数对之差
 * 
 * max[i]记录0~i的最大数，则状态递归方程为：
 * 
 * 1)max[i]=max(max(i-1),array(i))
 * 
 * 2)diff[i]=max(max[i-1]-array[i]，diff[i-1])
 * 
 * 自底向上分析， 初试max[1]=2，diff[1]=2-4=-2
 * 
 * max[2]=4，diff[2]=Max(4-1，diff[1])=3
 * 
 * max[3]=4，diff[3]=Max(4-16，diff[2])=3。……
 * 
 */
public class minarray {
	public void getmin(int[] arr) {
		int size = arr.length;
		int[] max = new int[size];
		int[] diff = new int[size];
		max[0] = arr[0];
		diff[0] = arr[0];
		for (int i = 1; i < size; i++) {
			max[i] = max[i - 1] > arr[i] ? max[i - 1] : arr[i];
			diff[i] = max[i - 1] - arr[i] > diff[i - 1] ? max[i - 1] - arr[i] : diff[i - 1];
		}
		for (int i = 0; i < size; i++) {
			System.out.print(max[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(diff[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 17, 3, 2, 9 };
		new minarray().getmin(array);
	}

}
