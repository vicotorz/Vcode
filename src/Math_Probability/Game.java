package Math_Probability;

//有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
//给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
public class Game {
	public int[] calc(int k) {
		// write code here
		int total = 1;
		int i = 1;
		while (2 * k - i > 1) {
			// Scanner sc = new Scanner(System.in);
			// sc.next();
			// System.out.println(k + "-" + i);
			total = total * (2 * k - i);
			i = i + 2;
		}
		System.out.println("【total】" + total);
		// Scanner sc = new Scanner(System.in);
		// sc.next();
		int fenzi = 1;
		// (k+1)!/2
		for (int t = k + 1; t >= 1; t--) {
			fenzi = fenzi * t;
		}
		fenzi = fenzi / 2;
		int[] result = new int[2];
		int gongyue = 0;
		if (total - fenzi != 0) {
			gongyue = huajian(total - fenzi, total);
			System.out.println("??" + gongyue);
			System.out.println((total - fenzi) + "--" + total);
			result[0] = (total - fenzi) / gongyue;
			result[1] = total / gongyue;
		} else {
			result[0] = (total - fenzi);
			result[1] = total;
		}

		return result;
	}

	//不能用递归
	public int huajian(int a, int b) {
		int yushu = b % a;
		//int shang = b / a;
		while (yushu > 0) {
			b = a;
			a = yushu;
			yushu = b % a;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] r = new Game().calc(5);
		System.out.println(r[0] + " " + r[1]);
	}
}
