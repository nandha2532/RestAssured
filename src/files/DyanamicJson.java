package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DyanamicJson {

	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type","application/json")
		.body(payload.addBook(isbn,aisle))
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
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
	
		//array = Collection of elements
		//multidimensional array = Collection of arrays
		return new Object[][] {{"ad1fss","2532"},{"ad1erss","2531"},{"ade1rscs","2533"}};
	
	}
	
}

