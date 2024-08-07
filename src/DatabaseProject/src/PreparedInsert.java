package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedInsert {

	public static void main(String[] args) {
        try {
        	Scanner scan = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("DRIVER ACTIVATED...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            System.out.println("Database Connected...!");
            PreparedStatement prs = con.prepareStatement("insert into student values(?,?,?)");
            int id = -1;
            
            while (id!=0) {
            	System.out.print("Enter id, name, age : ");
                id = scan.nextInt();
                
                if(id!=0)
                {
                	String na = scan.next();
                    int age = scan.nextInt();
                	prs.setInt(1, id);
                    prs.setString(2, na);
                    prs.setInt(3, age);
                    prs.execute();
                }
            }
            prs.close();
            con.close();
        } catch (Exception e) {
            System.out.print("\n ERROR  : " + e.getMessage());
            e.printStackTrace();
        }
	}

}
