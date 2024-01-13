package files;

public class payload {

	public static String AddPlace() {
		
		return"{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"NK Farm\",\r\n"
				+ "  \"phone_number\": \"(+91) 701 094 7766\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String CoursePrice() {
		
		return"{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 1162,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "},\r\n"
				+ "  {\r\n"
				+ "\"title\": \"Appium\",\r\n"
				+ "\"price\": 36,\r\n"
				+ "\"copies\": 7\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String addBook(String isbn, String aisle) {
		
//		return "{\r\n"
//				+ "\r\n"
//				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
//				+ "\"isbn\":\"bcd\",\r\n"
//				+ "\"aisle\":\"227\",\r\n"
//				+ "\"author\":\"John foe\"\r\n"
//				+ "}\r\n"
//				+ "";   (or)
		String payLoad = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return payLoad;
		
		
		
		
	}
	
public static String deleteBook(String bookId) {
		

		String payLoad = "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+bookId+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
		return payLoad;
		
		
		
		
	}
}
