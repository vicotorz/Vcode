package something_unfamiliar;

public class AboutFinally {

	public void fun() {
		try {
			System.out.println("try");
		} catch (Exception e) {

		} finally {
			System.out.println("finally");
		}
	}

	public static void main(String[] args) {
		new AboutFinally().fun();
	}

}
