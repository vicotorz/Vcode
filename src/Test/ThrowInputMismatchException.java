package Test;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowInputMismatchException {
	public static void main(String[] args) {
		showValue();
	}

	public static void showValue() {
		int a = 0;
		int sum = 0;
		while (a != 999) {
			System.out.println("锟斤拷锟斤拷锟斤拷numbers锟斤拷");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			int c = (int) a;
			try {
				if (c != a || a < 0) {
					System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�");
					a = sc.nextInt();
					throw new InputMismatchException();
				}
			}

			catch (InputMismatchException a1) {
				System.out.print(a1.toString());
			}
			if (a == 999) {
				sc.close();
			}

			sum = sum + a;
			System.out.print("Result" + sum + "\n");
		}
	}
}
