package APIDemo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest2 {

	@Test
	void getUsersList() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET, "/users");
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		if (response.statusCode() == 200) {
			System.out.println("PASS");
		}
		
		String StatusLine = response.getStatusLine();
		System.out.println("Status Line is : " +StatusLine);
	}
}
