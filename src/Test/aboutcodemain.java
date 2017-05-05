package Test;
import java.util.Scanner;

/**
 * 与aboutcode一起使用
 * 字符串颠倒  输出ASC码
 * */
public class aboutcodemain {

	public static void main(String[] args) {
		Scanner dr = new Scanner(System.in);
		System.out.println("请输入字符：");
		String str = dr.next();
		aboutcode t=new aboutcode();
		int u=t.isString(str);		
		if(u==1){
			t.convert(str);
		}else{
			System.out.println("该密码串是非法的，请不要解码");
		}
	}

}
