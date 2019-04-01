package something_unfamiliar;

public class StringAndInteger {
	public static void main(String[] args) {
		String a = "abc" + "d";
		String b = "abc" + new String("d");
		String c = "abcd";

		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(a == c);
		System.out.println(a == b.intern());

		Integer d = 100;
		Integer e = 100;
		System.out.println(d == e);
		Integer f = 150;
		Integer g = 150;
		System.out.println(f == g);
	}

}
