package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDatafromDatabase {

	public static void main(String[] args) throws SQLException {
		//Load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_details", "root", "D#3honey");
		
		Statement stmt = conn.createStatement();
		
		ResultSet result = stmt.executeQuery("Select * from employee");
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString("lastname")+" "+result.getString(4));
		}
		
		conn.close();

	}

}
