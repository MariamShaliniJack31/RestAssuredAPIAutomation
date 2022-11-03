package APIDemo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	void getUsersList() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.auth().none()
							.and()
							.request(Method.GET, "?page=2");
		
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		if (response.statusCode() == 200) {
			System.out.println("PASS");
		}
	}
}
