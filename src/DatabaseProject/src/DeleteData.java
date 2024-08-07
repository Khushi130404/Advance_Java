package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData {

	public static void main(String args[])
	{
		try {
			Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1","root","");
			Statement st = con.createStatement();
			System.out.print("Enter Student ID : ");
			int id = scan.nextInt();
			st.executeUpdate("delete from student where sid = "+id);
			System.out.println("Data Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
