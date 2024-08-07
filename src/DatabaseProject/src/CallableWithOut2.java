package DatabaseProject.src;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableWithOut2 {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER ACTIVATED...");
            Scanner scan = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            CallableStatement cst = con.prepareCall("call with_out2(?,?);");
            System.out.print("Enter Name : ");
            String na = scan.next();
            na = na.toLowerCase();
            cst.setString(1, na);
            cst.registerOutParameter(2, Types.INTEGER);
            cst.execute();
            int id = cst.getInt(2);
            System.out.println("Id : "+id);
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}

}
