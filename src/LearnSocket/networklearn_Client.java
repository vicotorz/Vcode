package LearnSocket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

public class networklearn_Client {

	/**这个代码中存在错误，TCP编程还没有完全理解！！！！！！
	 * 
	 * TCP套接字客户机实现代码
	 * 
	 * TCP简单客户端学习思路
	 * 
	 * 1.创建一个Socket用来连接到服务器上 
	 *                Socket connection=new Socket(serverAddress,port);
	 * 2.Socket的getInputStream方法和getOutputStream方法分别用于获得与Socket相关联的InputStream和OutputStream的引用
	 *                ObjectionInputStream input=new  ObjectInputStream(connection.getInputStream()); 
	 *                ObjectionOutputStream output=new ObjectOutputStream(connection.getOutputStream());
	 * 3.客户机与服务器通过InputStream和OutputStream对象通信的处理阶段
	 * 4.如果传输结束，通过调用相关流的close()以及Socket的close()关闭连接。
	 */

	int id = 0;
	Socket socket;

	public void connet(InetAddress inetAddress) throws IOException {
		socket = new Socket(inetAddress, networklearn_ServerSocket.Port_NUM);
	}

	public void comm() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		String cmd = input.readLine();
		if (cmd.equals("!!!")) {
			output.writeInt(id);
		}
		socket.close();
	}

	static AtomicInteger idGen = new AtomicInteger(1);// 这是什么？？

	public networklearn_Client() {
		this.id = idGen.getAndIncrement();
		System.out.println("Client Started" + id);
	}

	static public void main(String[] args) throws IOException {
		for (int i = 1; i < 5; i++) {
			new Thread() {
				public void run() {
					networklearn_Client client = new networklearn_Client();
					InetAddress inetAddress;
					try {
						inetAddress = InetAddress.getLocalHost();
						client.connet(inetAddress);
						client.comm();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}.start();
		}
	}
}
