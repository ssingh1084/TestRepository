package Test.Assessment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ValidatingTeam {

	public void checkValidation(String path) throws IOException, ParseException {
		
		JSONParser parsedFile = new JSONParser();
		FileReader readFile = new FileReader(path);
		Object obj = parsedFile.parse(readFile);
		JSONObject jsonObj = (JSONObject)obj;
		
		 
	}
	public static void main(String[] args) throws IOException, ParseException {
		ValidatingTeam team = new ValidatingTeam();
		team.checkValidation("../Assessment/Files/Team.json");
	}
}
