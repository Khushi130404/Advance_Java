package FactClient.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClientFact {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",1304);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter a number : ");
			int a = scan.nextInt();
			dos.writeInt(a);
			
			int b = dis.readInt();
			System.out.println("Factorial : "+b);
			
			dos.close();
			dis.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
