import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses() {
		
		JsonPath js = new JsonPath(payload.CoursePrice());

		int count = js.getInt("courses.size()");
		
		int sum=0;
		for(int i=0;i<count;i++) {
			
			String courseTitle = js.get("courses["+i+"].title");
			int coursePrices = js.get("courses["+i+"].price");
			int courseCopies = js.get("courses["+i+"].copies");
			int courseAmount = coursePrices*courseCopies;
			sum = sum+courseAmount;
			
			System.out.println(courseTitle+" : "+courseAmount);
		}
		
		System.out.println("Sum of all Course prices "+sum);
		
		int amount = js.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(sum, amount);
	}

}
