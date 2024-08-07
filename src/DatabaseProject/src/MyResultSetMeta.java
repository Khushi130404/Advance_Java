package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MyResultSetMeta {
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER ACTIVATED...");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
	        System.out.println("Database Connected...!");
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from student");
	        ResultSetMetaData rsm = rs.getMetaData();
	        System.out.println("Table : "+rsm.getTableName(1));
	        System.out.println("Column Count : "+rsm.getColumnCount());
	        
	        for(int i=1; i<=rsm.getColumnCount(); i++)
	        {
	        	System.out.println("Column : "+rsm.getColumnName(i)+"\tType : "+rsm.getColumnTypeName(i));
	        }
	        
	        while(rs.next())
	        {
	        	int sid = rs.getInt(1);
	        	String sna = rs.getString(2);
	        	int sag = rs.getInt(3);
	        	
	        	System.out.println(sid + "  " + sna + "  " + sag);
	        }
	        
	        rs = st.executeQuery("select count(*) from student");
	        rs.next();
	        System.out.println("Records : "+rs.getInt(1));
	        rs.close();
	        st.close();
	        con.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
        

	}
}
