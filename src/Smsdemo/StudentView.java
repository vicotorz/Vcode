package smsdemo;
import java.util.Scanner;


public class StudentView {
	private Scanner sc = new Scanner(System.in);
	public void mainView(){
		System.out.println("-------------Student Management System----------------");
		System.out.println("please choose the choices(1/2/3)");
		System.out.println("1 add student infomation");
		System.out.println("2 delete student infomation");
		System.out.println("3 exit the System");
		System.out.println("--------------------------------------");
		System.out.println("choose your item");
		
		int input = sc.nextInt();
		if(input == 1){
			addView();
		}
		else if(input==2){
			System.out.println("deleted choice");
		}
		else if(input==3){
			System.out.println("succesful quit");
			System.exit(0);
		}else{
			System.out.println("worry input,please choose the item agin");
			mainView();
		}
	}
	
	public void addView(){
		System.out.println("---------瀛︾敓淇℃伅澧炲姞-------------");
		System.out.println("璇疯緭鍏ュ鐢熶俊鎭紝鏍煎紡濡備笅锛氬鍙�濮撳悕/骞撮緞/鐢佃瘽锛岃緭鍏杩斿洖涓荤晫闈�");
		String rs = sc.next();
		if(rs.equals("q")){
			mainView();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentView().mainView();

	}

}
