package LearnSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class networklearn_ServerSocket {

	/**
	 * TCP客户端的实现代码
	 * 
	 * TCP简单服务器端学习思路
	 * 
	 * 1.创建一个ServerSocket对象 ServerSocket
	 * server=newServerSocket(port,queueLength);
	 * 2.调用Serversocket的accept()方法监听客户机 Socket connection=server.accept();
	 * 3.获得OutStream和InputStream对象 ObjectInputStream input=new
	 * ObjecInputStream(connection.getInputStream()); ObjectOutputStream
	 * output=new ObjectOutputStream(connection.getOutputStream());
	 * 4.服务器和客户机通过OutStream和InputStream对象通信的处理阶段
	 * 5.如果传输结束，通过调用相关流的close()以及Socket的close()关闭连接
	 */

	public static final int Port_NUM = 1000;

	ServerSocket serverSocket;

	public networklearn_ServerSocket() throws IOException {// 构造函数
		serverSocket = new ServerSocket(Port_NUM);// 1.第一步初始化(通过创建类的实例调用这个函数，创建ServerSocket)
	}

	public void start() throws IOException {// start方法对创建的socket进行监听
		while (true) {
			Socket socket = serverSocket.accept();// 2.监听
			new ServerThead(socket).start();
		}
	}

	public static void main(String[] args) {
		try {
			new networklearn_ServerSocket().start();// 创建类的实例，调用相关的构造方法并调用1这里的start方法（注意这里的start方法指的是socket开始监听）
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ServerThead extends Thread {
		Socket socket;

		ServerThead(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			Writer output;
			try {
				// -------------------------------------------------------------
				// 服务器和客户端通过OutputStream和InputStream对象进行通信处理
				output = new OutputStreamWriter(socket.getOutputStream());// 3.获得OutputStream
				DataInputStream input = new DataInputStream(
						socket.getInputStream());
				output.write("!!!");
				output.flush();
				System.out.println("Client connected! id:" + input.readInt());
				// -------------------------------------------------------------
				socket.close();// 关闭连接
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
