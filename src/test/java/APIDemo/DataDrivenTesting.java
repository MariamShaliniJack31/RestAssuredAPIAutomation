package APIDemo;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTesting {

	@Test(dataProvider = "EmployeeData")
	void DataDrivenCreateEmployee(String ename, String esal, String eage) {
		
		RestAssured.baseURI = "https://reqres.in/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", ename);
		requestparams.put("salary", esal);
		requestparams.put("age", eage);
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparams.toJSONString());
		
		Response response = httprequest.request(Method.POST, "/create");
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		if (response.statusCode() == 200 || response.statusCode() == 201) {
			System.out.println("PASS");
		}
		
		//System.out.println( response.jsonPath().get("id") );
	}
	
	
	@DataProvider(name = "EmployeeData")
	public String[][] empdata() {
		String[][] emparr = { {"Shalini", "200000", "41" }, {"Rufus", "400000", "41" }};
		return emparr;
	}
}
