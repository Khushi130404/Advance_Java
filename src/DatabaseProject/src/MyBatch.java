package DatabaseProject.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MyBatch {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER ACTIVATED...");
            Scanner scan = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            Statement st = con.createStatement();
            st.addBatch("delete from student where sid = 10");
            st.addBatch("insert into student values (10,'Meet',26)");
            st.addBatch("update student set sna = 'Kavya' where sid = 3");
            st.executeBatch();
            System.out.println("Done");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}
}
