package BFStudent;

import java.util.Scanner;

public class sms {
	private Scanner st = new Scanner(System.in);

	public void studentview() {
		System.out.println("----------------学生管理系统------------------");
		System.out.println("请选择以下功能（1/2/3）");
		System.out.println("1.增加学生信息");
		System.out.println("2.输出学生信息");
		System.out.println("3.退出系统");
		int input = st.nextInt();
		if (input == 1) {
			addStudent();
		} else if (input == 2) {
		} else if (input == 3) {
		} else {
		}
	}

	public void addStudent() {
		System.out.println("学生信息输入格式：学号/姓名/年龄/电话（按q退出）");
		String output2 = st.next();
		if (output2.equals("q")) {
			System.exit(0);
		} else {
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sms s=new sms();
		s.studentview();
	}

}
