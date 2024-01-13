import files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		
//		1. Print No of courses returned by API
		
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
//		2.Print Purchase Amount
		
		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
//		3. Print Title of the first course
		
		String title = js.get("courses[0].title");
		System.out.println(title);
		
//		4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++) {
			
		String courseTitle = js.get("courses["+i+"].title");
		int coursePrices = js.get("courses["+i+"].price");
		System.out.println(courseTitle+ ":" +coursePrices);
		
		
		}
		
//		5. Print no of copies sold by RPA Course
		for(int i=0;i<count;i++) {
			
			String courseTitle = js.get("courses["+i+"].title");
			
			if(courseTitle.equalsIgnoreCase("RPA")) {
				int copies = js.get("courses["+i+"].copies");
				System.out.println("no of copies sold by RPA Course :"+copies);
				
				break;
				
			}

			}
		
		
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		
		
		
		int sum=0;
		for(int i=0;i<count;i++) {
			
			String courseTitle = js.get("courses["+i+"].title");
			int coursePrices = js.get("courses["+i+"].price");
			int courseCopies = js.get("courses["+i+"].copies");
			
			sum = sum+(coursePrices*courseCopies);
			
			System.out.println(courseTitle+" : "+coursePrices*courseCopies);
			
		}
		
		System.out.println("Sum of all Course prices"+sum);
		
		if(amount==sum) {
		System.out.println("Sum of all Course prices matches with Purchase Amount");
		}

	}
}
