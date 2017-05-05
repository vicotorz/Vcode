package Files;

import java.io.*;
public class CopyFileDemo {
  	public static void main(String[] args) {
  	int b = 0;
  	FileInputStream in = null;
  	FileOutputStream out = null;
  try {
    in = new FileInputStream("G:/12.txt");
    out = new FileOutputStream("G:/1.txt");
    while((b=in.read())!=-1){
      out.write(b);
    }
    in.close(); 
    out.close();
  	} catch (FileNotFoundException e2) {
    	  System.out.println("Can't find file"); 
  	  System.exit(-1);
  	} catch (IOException e1) {
    	System.out.println("File copy error"); 
	System.exit(-1);
       }
  	System.out.println("File copy finished");
       }
}

