package DatabaseProject.src;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageJDBC {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER ACTIVATED...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            System.out.println("Database Connected...!");
            PreparedStatement pst = con.prepareStatement("insert into imgtab values (?,?)");
            FileInputStream fis = new FileInputStream("src//search.png");
            pst.setInt(1, 101);
            pst.setBinaryStream(2, fis);
            pst.execute();
            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}

}
