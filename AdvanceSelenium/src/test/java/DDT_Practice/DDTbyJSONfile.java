package DDT_Practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTbyJSONfile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser=new JSONParser();
		FileReader file=new FileReader("C:\\Users\\user\\eclipse-workspace_Ranjitha\\AdvanceSelenium\\src\\test\\resources\\DataOfAS.json");
		Object javaobj=parser.parse(file);
		
		JSONObject obj=(JSONObject) javaobj;
		String name = obj.get("Name").toString();
		String age = obj.get("age").toString();
		 Object age1 = obj.get("age");
		 String isStudent = obj.get("isStudent").toString();
		 String CourseCompleted = obj.get("Course_Completed").toString();
		 Object backlogs = obj.get("Backlogs");
		System.out.println(name);
		System.out.println(age);
		System.out.println(age1);
		System.out.println(isStudent);
		System.out.println(CourseCompleted);
		System.out.println(backlogs);
		

	}

}
