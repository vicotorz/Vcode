package ZOffer;

public class Add {
	public static int Add(int a, int b) {
		int sum = 0, carry;
		while (b != 0) {
			sum = a ^ b;
			carry = (a & b) << 1;
			a = sum;
			b = carry;
			System.out.println(sum + "," + carry);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Add(30, 3));

	}

}
