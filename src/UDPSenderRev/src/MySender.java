package UDPSenderRev.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MySender {

	public static void main(String[] args) {
		
		try
		{
			DatagramSocket sender = new DatagramSocket(1234);
			byte b[] =  new byte[1024];
			String msg = "";
			DatagramPacket pack = new DatagramPacket(b, b.length);
			sender.receive(pack);
			b = pack.getData();
			msg = new String(b);
			StringBuffer sb = new StringBuffer(msg);
			sb.reverse();
			msg = sb.toString();
			b = msg.getBytes();
			InetAddress ip = InetAddress.getByName("localhost");
			pack = new DatagramPacket(b, b.length, ip, 4321);
			sender.send(pack);
			sender.close();
		}
		catch (Exception e) {
			System.out.println("Sender Err : "+e.getMessage());
			e.printStackTrace();
		}

	}

}
