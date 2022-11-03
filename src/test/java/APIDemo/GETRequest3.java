package APIDemo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.*;

public class GETRequest3 {

	@Test
	void getUsersList() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
//		RequestSpecification httprequest = RestAssured.given();
//		Response response = httprequest.request(Method.GET, "/users");
		
		Response response = given().auth().none()
							.and()
							.contentType("application/json")
							.contentType(ContentType.JSON)
							
							.when()
							.get()
							
							.then()
							.assertThat().statusCode(200) 
							
							.and().assertThat().body("data[0].first_name", equalTo("George"))
							.and().assertThat().body(containsString("George"))
							.and().assertThat().body("data.first_name", hasItems("George", "Emma", "Eve"))
							
							
							.extract().response();
						
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		
		
		if (response.statusCode() == 200) {
			System.out.println("PASS 200");
		} else if (response.statusCode() == 201) {
			System.out.println("PASS 201");
		}
		
		String StatusLine = response.getStatusLine();
		System.out.println("Status Line is : " +StatusLine);
	}
}
