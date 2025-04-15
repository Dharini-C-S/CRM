package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTbyDatabase {

	public static void main(String[] args) throws SQLException {
		//loading database driver
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/NinzaCRM", "root", "D#3honey");
		
		Statement stmt = conn.createStatement();
		
		ResultSet res = stmt.executeQuery("select * from commondata");
		
		while(res.next()) {
			String browser = res.getString(1);
			String url = res.getString(2);
			String uname = res.getString(3);
			String pwd = res.getString(4);
			System.out.print(browser+ " ");
			System.out.print(url+ " ");
			System.out.print(uname+ " ");
			System.out.println(pwd);
			
		}
		conn.close();
	}

}
