package ChatClient.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClientChat {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",1304);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner scan = new Scanner(System.in);
			
			String s = "";
			
			while(s.equalsIgnoreCase("Q"))
			{
				s = dis.readUTF();
				System.out.print("Client : "+s);
				System.out.print("Enter a String...");
				s = scan.next();
				dos.writeUTF(s);
			}
			
			dos.close();
			dis.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


	}

}
