package Grammar;

public class Foroutput {

	/**
	 * 深刻理解for循环里的循环
	 */
	static boolean f(char c) {
		System.out.print(c);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		for (f('A'); f('B') && (i < 2); f('C')) {
			i++;
			f('D');
		}
	}

}
