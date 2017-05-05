package Grammar;

import java.util.*;

public class Rotation {
	public boolean chkRotation(String A, int lena, String B, int lenb) {
		// write code here
		boolean flag = false;
		if (lena == lenb) {
			String temp = A + A;
			for (int i = 0; i < lena; i++) {
				temp = A.substring(i, i + 5);
				if (temp.equals(B)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}
