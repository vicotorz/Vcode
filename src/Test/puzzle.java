package Test;

public class puzzle {
	public int func(int x) {
		int count = 0;
		while (x > 1) {
			count++;
			x = x & (x - 1);
			System.out.println(x);
		}
		return count;
	}

	public static void main(String[] args) {
		puzzle p = new puzzle();
		System.out.println(p.func(2015));
	}

}
