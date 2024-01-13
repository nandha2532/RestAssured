package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String resource) {
		
		JsonPath js1 =new JsonPath(resource);
		return js1;
	}

}
