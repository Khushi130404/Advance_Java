package UDPReceiverRev.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MyReceiver {

	public static void main(String[] args) {
		try
		{
			DatagramSocket receiver = new DatagramSocket(4321);
			Scanner scan = new Scanner(System.in);
			System.out.print("Message : ");
			String msg = scan.next();
			byte b[] = new byte[1024];
			b = msg.getBytes();
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket pack = new DatagramPacket(b, b.length, ip, 1234);
			receiver.send(pack);
			
			receiver.receive(pack);
			b = pack.getData();
			msg = new String(b);
			System.out.println("Reverse : "+msg);
			receiver.close();
		}
		catch (Exception e) {
			System.out.println("Receiv Err : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
