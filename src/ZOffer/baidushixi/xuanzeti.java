package baidushixi;

public class xuanzeti {
	public int f(int i) {
		int count = 1;
		while (i > 0) {
			System.out.println(i);
			i = i & (i - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new xuanzeti().f(1000));
	}

}
