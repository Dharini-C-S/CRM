package DDTPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataIntoProperties {

	public static void main(String[] args) throws IOException {
		Properties prop= new Properties();
		prop.setProperty("browser", "chrome");
		prop.setProperty("url", "http://localhost:8888");
		prop.setProperty("username", "admin");
		prop.setProperty("password", "admin");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Data.properties");
		prop.store(fos, "Storing data");
		
	}

}
