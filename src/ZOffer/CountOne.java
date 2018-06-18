package ZOffer;

public class CountOne {

	public static int count(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			count = count + getOne(i);
		}
		return count;
	}

	public static int getOne(int num) {
		// System.out.println(num);
		int shang = num;
		int yu = 0;
		int count = 0;
		while (shang != 0 || yu != 0) {
			if (yu == 1) {
				count++;
			}
			// System.out.println(shang + "--" + yu);
			yu = shang % 10;
			shang = shang / 10;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(1346, 21345));

	}

}
