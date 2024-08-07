package DatabaseProject.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedDelete {

	public static void main(String[] args) {
        try {
        	Scanner scan = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("DRIVER ACTIVATED...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1", "root", "");
            System.out.println("Database Connected...!");
            PreparedStatement prs = con.prepareStatement("delete from student where sid = ?");
            int id = -1;
            
            while (id!=0) {
            	System.out.print("Enter id to delete : ");
                id = scan.nextInt();
                
                if(id!=0)
                {
                	prs.setInt(1, id);
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
