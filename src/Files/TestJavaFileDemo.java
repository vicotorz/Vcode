package Files;

import java.io.*;

public class TestJavaFileDemo {
	public static void main(String[] args) {
		String filename = "myfile.txt";
		String directory = "java test " + "src" + "/" + "teacher";
		File f = new File(directory, filename);
		if (f.exists()) {
			System.out.println("File Name: " + f.getName());
			System.out.println("File Length: " + f.length());
		} else {
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
