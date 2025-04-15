package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDatToDatabase {
	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_details", "root", "D#3honey");
		
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate("insert into employee values(3,'Yajna','Rishi','Tripura')");
		
		if(result ==1 ) {
			System.out.println("Data inserted successfully");
		}
		else {
			System.out.println("Data insertion failed");
		}
		
		ResultSet res = stmt.executeQuery("select * from employee");
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
		}
		
		conn.close();
	}
}
