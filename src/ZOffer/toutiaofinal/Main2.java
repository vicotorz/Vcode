package toutiaofinal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

	public static int countZhu(String line) {
		int count = 0;
		Pattern p = Pattern.compile("(//){1,}[a-zA-Z0-9]{1,}", Pattern.CASE_INSENSITIVE);
		Pattern p2 = Pattern.compile("(/\\*)[a-zA-Z0-9]{1,}(\\*/)", Pattern.CASE_INSENSITIVE);
		Pattern p3 = Pattern.compile("(\")((//){0,}|(/\\*)(0,))[a-zA-Z0-9]{1,}((//){0,}|(\\*/){0,})(\")",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(line);
		Matcher m2 = p2.matcher(line);
		Matcher m3 = p3.matcher(line);
		while (m.find()) {
			count++;
		}
		while (m2.find()) {
			count++;
		}
		while (m3.find()) {
			count--;
		}
		return count;
	}

	public static void main(String[] args) {
		// int result = 0;
		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNext()) {
		// String line = sc.nextLine();
		// result += countZhu(line);
		// }
		// System.out.println(result);
		Pattern p3 = Pattern.compile("(/\\*)[a-zA-Z0-9]{1,}(\\*/)", Pattern.CASE_INSENSITIVE);
		Matcher m3 = p3.matcher("/*ffdf*/");
		int count = 0;
		while (m3.find()) {
			count--;
		}
		System.out.println(count);
		// System.out.println(countZhu("\"//asdsa\"\\gfggg\\*sadsa*\\"));
	}

}
