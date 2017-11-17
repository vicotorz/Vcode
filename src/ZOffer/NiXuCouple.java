package ZOffer;

public class NiXuCouple {

	//复杂度过大
	public static int ReveseCouple(int[] number) {
		int result = 0;
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number.length; j++) {
				if (number[j] > number[i]) {
					//System.out.println(number[i] + "," + number[j]);
					result++;
					int temp = number[j];
					number[j] = number[i];
					number[i] = temp;

				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] number = { 3, 2, 1 };
		System.out.println(ReveseCouple(number));
	}

}
