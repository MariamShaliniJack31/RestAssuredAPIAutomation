package APIDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POSTRequest2 {

	@Test
	void CreateEmployee() throws FileNotFoundException {
		
		FileInputStream Filepath = new FileInputStream(new File(".//src//test//java//APIDemo//PostAPI.json"));
		RestAssured.baseURI = "https://reqres.in/api/v1";
		
		Response response = given().contentType("application/json")
							.and().auth().none()
							.and().body(Filepath)
							.header("Content-Type","application/json" )
												
							.when()
							.post("/create")
							
							.then()
							.statusCode(201)
							.and().assertThat().body("name", equalTo("Shalini"))
							.log().all()		
							
							.extract().response()
							;
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		if (response.statusCode() == 200 || response.statusCode() == 201) {
			System.out.println("Status Code is : "+ response.statusCode());
		}
		
		System.out.println("ID created is : "+response.jsonPath().get("id") );
		
		Headers allheaders = response.headers();
		for(Header header : allheaders) {
			System.out.println(header.getName() +"                 "+header.getValue());
		}
		
		System.out.println("Response Time is : "+response.getTime());
		
		if (ResponseBody.contains("name")) {
			System.out.println("PASS");
		}
		//ResponseBody.
		
		JsonPath jsonpath = response.jsonPath();
		//System.out.println(jsonpath.get("name"));
		
		Assert.assertEquals(jsonpath.get("name"), "Shalini");
	}
}
