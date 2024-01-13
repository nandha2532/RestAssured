package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class StaticJson {

	@Test
	public void staticAddBook() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";

		String response = given().log().all().header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\vnand\\NK\\API\\doc\\AddBook.json"))))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJson(response);
		String id=js.get("ID");
		System.out.println(id);
		
//		String resp1 = given().log().all().header("Content-Type","application/json")
//		.body(payload.deleteBook(id))
//		.when().post("Library/DeleteBook.php")
//		.then().log().all().assertThat().statusCode(200)
//		.extract().response().asString();
//		
//		JsonPath js1 = ReusableMethods.rawToJson(resp1);
//		
//		System.out.println(js1.get("msg").toString());
//		
		
	}
	
	
	@Test
	public void staticAddBookBy() throws IOException {
		
//		Properties prop= new Properties();
		File file = new File("C:\\Users\\vnand\\NK\\API\\doc\\AddBook.json");
//		FileInputStream fis= new FileInputStream(file);
//		prop.load(fis);
		
		RestAssured.baseURI = "http://216.10.245.166";

		String response = given().log().all().header("Content-Type","application/json")
				.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJson(response);
		String id=js.get("ID");
		System.out.println(id);
		
		String resp1 = given().log().all().header("Content-Type","application/json")
		.body(payload.deleteBook(id))
		.when().post("Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js1 = ReusableMethods.rawToJson(resp1);
		
		System.out.println(js1.get("msg").toString());
		
		
	}
	
}

