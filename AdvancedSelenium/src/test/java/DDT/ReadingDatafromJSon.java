package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingDatafromJSon {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser= new JSONParser();
		FileReader file = new FileReader("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\JsonData.json");
		Object obj = parser.parse(file);
		
		JSONObject jsonObj =(JSONObject)obj;
		
		String name = jsonObj.get("name").toString();
		String id = jsonObj.get("id").toString();
		String branch = jsonObj.get("Branch").toString();
		String age = jsonObj.get("Age").toString();
		String isEngineer = jsonObj.get("isEngineer").toString();
		Object favourites = jsonObj.get("favourites");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(branch);
		System.out.println(age);
		System.out.println(isEngineer);
		System.out.println(favourites);
		
	}

}










