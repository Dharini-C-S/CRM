package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		
		/**
		 * Accessing data from properties file(External Resources)
		 * @author Dharini C S
		 */
				FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties");
				
				Properties prop = new Properties();
				prop.load(fis);
				
				String value =prop.getProperty(key);
		
		return value;
		
	}
	
}
