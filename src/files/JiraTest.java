package files;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// this. --> refers to current class variable
		
		Pojo pojo = new Pojo();
		Pojo p1 = new Pojo("12");
		pojo.setId("1");
		NestedClass nestedClass = new NestedClass();
		nestedClass.setName("nested1");
		pojo.setNestedClass(nestedClass);
		List<String> strings = new ArrayList<String>();
		strings.add("string1");
		strings.add("string2");
		
		pojo.setStringList(strings);
		
//		{ "id" : "1", "nestedClass" :{"name" : "nested1"} , "stringList" : ["string2","string2"]};
		System.out.println(pojo);
		
		RestAssured .baseURI="http://localhost:8080";
		
		SessionFilter sesssion = new SessionFilter();
		
		String response = given().relaxedHTTPSValidation().header("Content-Type","application/json").body("{ \"username\": \"nandha\", \"password\": \"N&a@25321910\" }")
		.log().all().filter(sesssion)
		.when().post("/rest/auth/1/session")
		.then().extract().response().asString();
		
//		JsonPath js = ReusableMethods.rawToJson(response);
//		String id=js.get("value");
//		System.out.println(id);
		
		
		// Add comment
		String expectMsg = "This is my First comment";
		String commentResp = given().pathParam("id", "10203").log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \""+expectMsg+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(sesssion)
		.when().post("/rest/api/2/issue/{id}/comment")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = new JsonPath(commentResp);
		String commId = js.get("id");
		
		//Add Attachment
		given().pathParam("id", "10203").header("X-Atlassian-Token","no-check").filter(sesssion).pathParam("id", "10203")
		.header("Content-Type","multipart/form-data").multiPart("file",new File("C:\\Users\\vnand\\NK\\API\\ApiDemo\\DemoProject\\jira.txt"))
		.when().post("/rest/api/2/issue/{id}/attachments")
		.then().assertThat().statusCode(200).log().all();
		
		//Get Issue details
		String issueDetails =given().log().all().pathParam("id","10203").filter(sesssion)
				.queryParam("fields", "comment")
		.when().get("/rest/api/2/issue/{id}")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(issueDetails);
		
		JsonPath js1 = new JsonPath(issueDetails);
		int commCount = js1.get("fields.comment.comments.size()");
		
		for(int i=0;i<commCount;i++) {
			String respCommId = js1.get("fields.comment.comments["+i+"].id");
			
			if(respCommId.equalsIgnoreCase(commId)) {
				String respComm = js1.get("fields.comment.comments["+i+"].body");
				System.out.println(respComm);
				Assert.assertEquals(respComm, expectMsg);
				break;
			}
			
//			Comment
		}
		
		
		

	}

}
