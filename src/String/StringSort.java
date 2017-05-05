package String;

import java.util.Arrays;

/**
 * 字符串排序 getByte()
 * */
public class StringSort {
	public static void main(String[] args) {
		String str = "zfdecdgwkig";
		byte[] b = str.getBytes();
		Arrays.sort(b);
		str = new String(b);
		System.out.println(str);

	}

}
