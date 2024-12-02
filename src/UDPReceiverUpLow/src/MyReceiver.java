package UDPReceiverUpLow.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MyReceiver {

	public static void main(String[] args) {
		try {
			DatagramSocket receiver = new DatagramSocket(1340);
			byte[] b = new byte[1024];
			Scanner scan = new Scanner(System.in);
			System.out.print("Message : ");
			String msg = scan.next();
			b = msg.getBytes();
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(b,b.length,ip,1304);
			receiver.send(packet);
			receiver.receive(packet);
			b=packet.getData();
			msg = new String(b);
			System.out.println("Upper : "+msg);
			receiver.close();
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
