package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1","root","");
			Statement st = con.createStatement();
			System.out.print("Enter the id to update : ");
			int sid = scan.nextInt();
			System.out.print("Enter the Name : ");
			String sna = scan.next();
			System.out.print("Enter the age : ");
			int sag = scan.nextInt();
			st.executeUpdate("update student set sna = '"+sna+"',sag = "+sag+" where sid = "+sid);
			System.out.print("Record Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
