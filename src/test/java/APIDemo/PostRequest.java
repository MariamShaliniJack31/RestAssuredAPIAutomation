package APIDemo;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	void CreateEmployee() {
		
		RestAssured.baseURI = "https://reqres.in/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("name", "Rufus");
		requestparams.put("salary", "27LPA");
		requestparams.put("age", "41");
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparams.toJSONString());
		
		Response response = httprequest.request(Method.POST, "/create");
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		if (response.statusCode() == 200 || response.statusCode() == 201) {
			System.out.println("PASS");
		}
		
		//System.out.println(response.jsonPath().get("id") );
	}
}
