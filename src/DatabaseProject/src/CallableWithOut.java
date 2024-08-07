package DatabaseProject.src;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableWithOut {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER ACTIVATED...");
            Scanner scan = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            CallableStatement cst = con.prepareCall("call with_out(?,?);");
            System.out.print("Enter id : ");
            int id = scan.nextInt();
            cst.setInt(1, id);
            cst.registerOutParameter(2, Types.INTEGER);
            cst.execute();
            int ag = cst.getInt(2);
            System.out.println("Age : "+ag);
            cst.close();
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}
}
