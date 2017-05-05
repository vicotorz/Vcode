package Student;
import java.util.Random;


public class unionStudent {

	public static void main(String[] args) {
		StudentClass[] ai = new StudentClass[10];
		int size = ai.length;
		for (int i = 0; i < size; i++) {
			ai[i] = new StudentClass();
		}

		Random random = new Random();// 利用随机数

		for (int t = 0; t < size; t++) {
			ai[t].setName("小" + (t + 1));
			/* //ai[t].setAge(10 - t); */
			ai[t].setAge(random.nextInt(21) + 10);// 产生随机数
			ai[t].setStudynumber(t + 1);

		}
		for (int y = 0; y < size; y++) {
			int min = ai[y].getAge();
			for (int p = y + 1; p < size; p++) {
				if (ai[p].getAge() < min) {
					min = ai[p].getAge();
					{
						String a;
						int b;
						int c;
						a = ai[y].getName();
						b = ai[y].getAge();
						c = ai[y].getStudynumber();
						ai[y].setName(ai[p].getName());
						ai[y].setAge(ai[p].getAge());
						ai[y].setStudynumber(ai[p].getStudynumber());
						ai[p].setName(a);
						ai[p].setAge(b);
						ai[p].setStudynumber(c);

					}

				}
			}
		}

		for (int e = 0; e < size; e++) {
			System.out.println("姓名：     " + ai[e].getName());
			System.out.println("年龄：     " + ai[e].getAge());
			System.out.println("学号：     " + ai[e].getStudynumber());
			System.out.println("=====================================");
		}

	}
}
