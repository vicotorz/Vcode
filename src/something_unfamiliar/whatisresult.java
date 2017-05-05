package something_unfamiliar;

public class whatisresult {
	public int cnt = 0;

	public int fib(int n) {
		cnt++;
		if (n == 0)
			return 1;
		else if (n == 1) {
			return 2;
		} else
			return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		whatisresult w = new whatisresult();
		w.fib(8);
		System.out.println(w.cnt);
	}

}
