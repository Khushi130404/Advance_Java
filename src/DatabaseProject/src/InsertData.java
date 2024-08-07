package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class InsertData {

	public static void main(String[] args) {
		
		try {
			Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Activated...!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1","root","");
			System.out.println("Database Connected...!");
			Statement st = con.createStatement();
			System.out.println("Provide info of Student...");
			System.out.print("Provide ID : ");
			int sid = scan.nextInt();
			System.out.print("Provide Name : ");
			String sna = scan.next();
			System.out.print("Provide Age : ");
			int sag = scan.nextInt();
			
			st.executeUpdate("insert into student value ("+sid+",'"+sna+"',"+sag+")");
			System.out.println("Data inserted");
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		

	}

}
