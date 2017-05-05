package Test;
public class aboutcode {
	public int isString(String str) {
		int i = 1;
		int s = str.length();
		for (int w = s - 1; w >= 0; w--) {
			int e = str.charAt(w);
			if (e > 122 || (90 < e && e < 97) || e < 65) {
				 i = 0;
			}
		}
		return i;
	}
	
	public void convert(String d) {
		int r = d.length();
		for (int i = r - 1; i >= 0; i--) {
			int c = d.charAt(i);
			System.out.print(c);
		}

	}

	public boolean checknumber(String t, int o) {
		int i = Integer.parseInt(t, 10);
		System.out.println(i);
		if (o == 1 && i == 158) {
			return true;
		}
		if (o == 2 && i == 168) {
			return true;
		}
		if ((o == 3 || o == 4) && (i >= 0) && (i <= 255)) {
			return true;
		}
		return false;
	}
}
