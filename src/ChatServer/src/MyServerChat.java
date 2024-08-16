package ChatServer.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerChat {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1304);
			System.out.println("Server waiting to Connect");
			Socket client = server.accept();
			System.out.println("Welcome Client");
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			Scanner scan = new Scanner(System.in);
			String s = "";
			
			while(s.equalsIgnoreCase("Q"))
			{
				System.out.print("Enter a String...");
				s = scan.next();
				dos.writeUTF(s);
				s = dis.readUTF();
				System.out.print("Client : "+s);
			}
			
			dos.close();
			dis.close();
			client.close();
			server.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


	}

}
