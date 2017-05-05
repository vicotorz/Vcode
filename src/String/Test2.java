package String;

class Test2 {
	public static void main(String[] args) {
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		int testa = 1;

		System.out.println("a.equals(testa)" + a.equals(testa));
		System.out.println(a == b);
		System.out.println("a.equals(b)" + a.equals(b));

		// ---------------------------------------------------------//
		String aa = "abc";
		String bb = "abc";

		System.out.println(aa == bb);
		System.out.println(aa.equals(bb));

		char c[] = { 'a', 's' };
		System.out.println(c);
		System.out.println(aa.substring(1, 3));

		StringBuffer sb = new StringBuffer("hello");
		sb.delete(0, 1);
		System.out.println(sb.replace(0, 0, "i"));
	}
}
