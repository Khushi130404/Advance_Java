package AddServer.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1304);
			System.out.println("Server waiting to Connect");
			Socket client = server.accept();
			System.out.println("Welcome Client");
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			int x = dis.readInt();
			int y = dis.readInt();
			
			int z = x+y;
			dos.writeInt(z);
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
