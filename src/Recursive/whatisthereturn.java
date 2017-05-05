package Recursive;

public class whatisthereturn {

	/**
	 * @param args
	 *            阿里巴巴有关递归的题
	 * 
	 */

	int foo(int n) {
		if (n <= 2)
			return n;
		return foo(n - 1) + foo(n - 2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		whatisthereturn is = new whatisthereturn();
		System.out.println(is.foo(6));
	}

}
