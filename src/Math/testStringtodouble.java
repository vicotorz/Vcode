package Math;

public class testStringtodouble {

	/**
	 * ceil 以及 floor
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double f = 9.0;
		System.out.println(String.valueOf(f));

		String str = "9.0";
		System.out.println(Double.parseDouble(str));

		double test = 9.8;
		System.out.println(Math.ceil(test));
		System.out.println(Math.floor(test));
	}
}
