package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.out.println("Usage: java UDPClient <hostname>");
			return;
		}

		DatagramSocket socket = new DatagramSocket();

		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName(args[0]);
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address,
				4445);
		socket.send(packet);

		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);

		String received = new String(packet.getData(), 0, packet.getLength(), "utf-8");
		System.out.println("Server Say: " + received);

		socket.close();
	}
}
