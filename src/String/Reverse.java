package String;

/**
 * 实现字符串反转
 * 
 * how are you--> you are how
 * 
 * 两次反转就可以
 * 
 * */

public class Reverse {
	public String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "how are you";
		Reverse r = new Reverse();
		str = r.reverse(str);
		String[] s = str.split(" ");
		StringBuffer tsb = new StringBuffer();
		for (int t = 0; t < s.length; t++) {
			tsb.append(r.reverse(s[t]) + " ");
		}
		System.out.println(tsb.toString());

	}

}
