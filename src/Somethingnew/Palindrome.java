package somethingnew;

public class Palindrome {

	/**
	 * 
	 * 2014.9.29
	 * 
	 * 
	 * 问题： 递归回文判断
	 * 
	 */

	public void Palindrome_test(String str, int start, int end) {
		if (start == end) {
			System.out.println("是回文");
			return;
		}
		if (str.charAt(start) == str.charAt(end)) {
			Palindrome_test(str, start + 1, end - 1);
		} else {
			System.out.println("不是回文");
			return;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdedcba";
		String str2 = "abcdeecba";
		int end = str.length() - 1;

		Palindrome p = new Palindrome();
		p.Palindrome_test(str, 0, end);
		p.Palindrome_test(str2, 0, str2.length() - 1);

	}

}
