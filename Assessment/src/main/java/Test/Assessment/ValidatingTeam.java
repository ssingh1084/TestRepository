package Test.Assessment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ValidatingTeam {

	public void checkValidation(String path) throws IOException, ParseException {
		
		int foreignPlayerCount = 0;
		int wicketKeeperCount = 0;
		JSONParser parsedFile = new JSONParser();
		FileReader readFile = new FileReader(path);
		Object obj = parsedFile.parse(readFile);
		JSONObject jsonObj = (JSONObject)obj;
		JSONArray jsonArr = (JSONArray)jsonObj.get("player");
		for (int i = 0 ; i < jsonArr.size(); i++) {
			JSONObject player = (JSONObject)jsonArr.get(i);
			String country = (String) player.get("country");
			String role = (String) player.get("role");
			if(!country.equals("India")) {
				foreignPlayerCount++;
			}
			if(role.equals("Wicket-keeper")) {
				wicketKeeperCount++;
			}
		}
		if(foreignPlayerCount == 4 && wicketKeeperCount == 1) {
			System.out.println("Team Selection is Correct");
		}else {
			System.out.println("Team Selction is not Correct");
		}
		
		 
	}
	public static void main(String[] args) throws IOException, ParseException {
		ValidatingTeam team = new ValidatingTeam();
		team.checkValidation("../Assessment/Files/Team.json");
	}
}
