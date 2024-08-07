package DatabaseProject.src;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageJDBCRead {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER ACTIVATED...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            System.out.println("Database Connected...!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from imgtab;");
            rs.next();
            int id = rs.getInt(1);
            InputStream is =rs.getBinaryStream(2);
            FileOutputStream fos = new FileOutputStream("src//search_out.png");
            int n = 0;
            while(n!=-1)
            {
            	n = is.read();
            	fos.write(n);
            }
            fos.close();
            is.close();
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}

}
