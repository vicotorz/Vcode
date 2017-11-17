package ZOffer;

public class LastNumber {

	public static int LastRemaining(int n, int m) {
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
			System.out.println("删除："+last);
		}
		return last;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LastRemaining(5, 3));

	}

}
