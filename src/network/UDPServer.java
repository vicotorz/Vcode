package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		new UDPServerThread().start();
	}
}

class UDPServerThread extends Thread {

	protected DatagramSocket socket = null;
	protected BufferedReader in = null;
	protected boolean moreQuotes = true;

	public UDPServerThread() throws IOException {
		super();
		socket = new DatagramSocket(4445);
		in = new BufferedReader(new StringReader("one\r two\r three\r four\r five\r six\r seven\r"));
	}

	public void run() {
		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];

				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				String dString = getNextQuote();

				buf = dString.getBytes("utf-8");

				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port);
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
		}
		socket.close();
	}

	protected String getNextQuote() {
		String returnValue = null;
		try {
			if ((returnValue = in.readLine()) == null) {
				in.close();
				moreQuotes = false;
				returnValue = "No more quotes. Goodbye.";
			}
		} catch (IOException e) {
			returnValue = "IOException occurred in server.";
		}
		return returnValue;
	}
}