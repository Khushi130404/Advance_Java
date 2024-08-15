package RevStringClient.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClientRevString {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",1304);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter a String : ");
			String s = scan.next();
			
			dos.writeUTF(s);
			
			String st = dis.readUTF();
			System.out.println("Reverse String : "+st);
			
			dos.close();
			dis.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
