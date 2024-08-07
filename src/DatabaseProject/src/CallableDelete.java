package DatabaseProject.src;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableDelete {

	public static void main(String[] args) {
		try {
        	Scanner scan = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER ACTIVATED...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            CallableStatement cst = con.prepareCall("call deleteRecord(?);");
           	System.out.print("Enter id to delete : ");
            int id = scan.nextInt();
            cst.setInt(1,id);
            cst.execute();
            cst.close();
            con.close();
            System.out.println("Done");
            
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}

}
