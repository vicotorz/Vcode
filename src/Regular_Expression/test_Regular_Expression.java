package Regular_Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test_Regular_Expression {

	/**
	 * @param args
	 *            正则表达式匹配
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stringregx = "^<789";
		String str = "<78959595";
		String str2 = "<TOPICS><D>corn</D></TOPICS>";
		Pattern p = Pattern.compile(stringregx);
		Matcher m = p.matcher(str);
		System.out.println(m.find());
		System.out.println(str2.length());
		System.out.println(str2.indexOf("</D>"));
		System.out.println(str2.substring(11, str2.indexOf("</D>")));
		String string = "F:/test3/train/wheat";
		String[] strs = string.split("/");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}

	}
}
