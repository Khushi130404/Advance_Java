package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateResultSet {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("\n DRIVER ACTIVATED...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            System.out.println("Database Connected...!");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from emp");

            rs.absolute(3);
            rs.updateString(2, "Kavi");
            rs.updateRow();
            rs = st.executeQuery("select * from emp");
            while (rs.next()) {
                int id = rs.getInt(1);
                String na = rs.getString(2);
                int age = rs.getInt(3);
                System.out.println(id + "  " + na + "  " + age);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}
}
