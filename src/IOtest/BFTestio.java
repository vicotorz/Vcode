package IOtest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 有关文件的练习
 * */
public class BFTestio {

	private static BufferedReader br;
	private static BufferedWriter bw;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File in = new File("e:\\新建文本文档.txt"); // 1.先创建一个输入File
		File out = new File("e:\\rr.txt"); // 2.创建一个输出File
		FileReader f1; 
		try {
			f1 = new FileReader(in); // 3.FileReader
			FileWriter f2;// 4.FileWriter
			if (out.exists()) {
				f2 = new FileWriter(out, true); // 在文件后面进行追加内容
			} else {
				f2 = new FileWriter(out);
			}
			br = new BufferedReader(f1);// 5.BufferedReader
			bw = new BufferedWriter(f2);// 6.BufferedWriter
			String c;
			while ((c = br.readLine()) != null) {
				bw.write(c + "\r\n");
				bw.flush();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
