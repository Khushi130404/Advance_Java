package ChatClient.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClientChat {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",1300);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner scan = new Scanner(System.in);
			
			String s = "";
			
			while(!s.equalsIgnoreCase("Quit"))
			{
				s = dis.readUTF();
				System.out.println("Server : "+s);
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
