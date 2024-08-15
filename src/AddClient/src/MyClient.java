package AddClient.src;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",1304);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter 2 nums : ");
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			dos.writeInt(a);
			dos.writeInt(b);
			
			int c = dis.readInt();
			System.out.println(c);
			
			dos.close();
			dis.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
