package IOtest;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class testio {
	private static FileReader f1;
	private static FileWriter f2;

	public static void main(String[] args) {
		try {
			f1 = new FileReader("e:\\新建文本文档.txt");

			f2 = new FileWriter("e:\\1.txt");
			int c;
			while ((c = f1.read()) != -1) {
				f2.write(c);
				f2.flush();// 强制刷新
				// System.out.print((char) c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
