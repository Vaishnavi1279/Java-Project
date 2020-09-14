import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Connectionc {
	public static Connection c()
	{
		Connection con=null;
	try {
		Class.forName("org.sqlite.JDBC"); 
		String url = "jdbc:sqlite:C:\\Users\\hp\\Desktop\\mydatabasefile.db";
		con = DriverManager.getConnection(url);
	}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
	return(con);
}
	
}	

