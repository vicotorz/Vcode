package something_unfamiliar;

/**
 * strictfp 修饰的变量和类，为精确浮点
 * */
public class test_strictfp {
	public strictfp void sum(float a, double d) {
		System.out.println("精确得数:  " + (a + d));
	}

	public void sum1(float a, double d) {
		System.out.println("不精确得数:" + (a + d));
	}

	public static void main(String[] args) {
		float a = 0.12365f;
		double d = 0.3496421d;
		test_strictfp ts = new test_strictfp();
		ts.sum(a, d);
		ts.sum1(a, d);

	}
}
