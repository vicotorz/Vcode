package moneypractice;

public class String_test {

	/**
	 * 像这样遍历字符串然后替换掉当前字符串的方法，实现不了 String这个是在堆区产生的固定的，不能修改（不要忘）
	 * 
	 * replaceFirst是替换第一个出现的指定字符
	 * 
	 * StringBuffer有一个重要的方法是append()方法 public StringBuffer deleteCharAt(int
	 * index) public StringBuffer delete(int start,int end) public StringBuffer
	 * insert(int offset, boolean b) public StringBuffer reverse() public void
	 * setCharAt(int index, char ch)
	 * 
	 * 说明：该方法的作用是修改对象中索引值为index位置的字符为新的字符ch。例如：
	 * 
	 * StringBuffer sb = new StringBuffer(“abc”);
	 * 
	 * sb.setCharAt(1,’D’);
	 * 
	 * 则对象sb的值将变成”aDc”。
	 */
	public static void main(String[] args) {

		// 方法1
		String str = "abcdeeeeeeee";
		String replaceStr = str.replace("e", "y");
		System.out.println(replaceStr);

		// 方法2
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 'a') {
				newStr += str.charAt(i);
			} else {
				newStr += 'y';
			}
		}

		System.out.println(newStr);

		// -------------------------------------------------------------------------------------------------//

		// 方法3
		StringBuffer st = new StringBuffer("abcde");
		System.out.println(st.length());
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == 'a') {
				st.setCharAt(i, 't');// 就这么写
			}
		}
	}
}
