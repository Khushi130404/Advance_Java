package UDPSenderUpLow.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class MySender {

	public static void main(String[] args) {
		try {
			DatagramSocket sender = new DatagramSocket(1304);
			String msg = "";
			byte[] b = new byte[1024];
			DatagramPacket packet = new DatagramPacket(b,b.length);
			sender.receive(packet);
			b = packet.getData();
			msg = new String(b);
			msg = msg.toUpperCase();
			b = msg.getBytes();
			InetAddress ip = InetAddress.getByName("localhost");
			packet = new DatagramPacket(b, b.length,ip,1340);
			sender.send(packet);
			sender.close();
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
