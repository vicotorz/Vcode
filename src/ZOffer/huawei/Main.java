package huawei;
import java.util.Scanner;

public class Main {
	public int[] array;

	public void Op(int[] array, String op, int A, int B) {
		// ID从A到B--- Q A-1的位置 B-1的位置
		// 将A改成B--- U A-1的位置
		if (op.equals("Q")) {
			int max = array[A-1];
            if(A>B){
                int temp=B;
                B=A;
                A=temp;
            }
			for (int i = A - 1; i <= B - 1; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
			System.out.println(max);
		}

		if (op.equals("U")) {
			array[A - 1] = B;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int Stunum = sc.nextInt();
			int Operationnum = sc.nextInt();
			m.array = new int[Stunum];
			for (int index = 0; index < Stunum; index++) {
				m.array[index] = sc.nextInt();
			}
			// ID从A到B Q
			// 将A改成B U
			for (int t = 0; t < Operationnum; t++) {
				String st = sc.next();
				int A = sc.nextInt();
				int B = sc.nextInt();
				m.Op(m.array, st, A, B);
			}
		}

	}

}
