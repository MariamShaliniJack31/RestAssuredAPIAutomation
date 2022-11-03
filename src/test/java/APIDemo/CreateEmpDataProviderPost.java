package APIDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmpDataProviderPost {
	
	@Test(dataProvider = "CreateEmployee")
	void CreateEmpfromDataProvider(String ename, String esal, String eage) {
		
		RestAssured.baseURI = "https://reqres.in/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("Name", ename );
		requestparams.put("Salary", esal );
		requestparams.put("Age", eage );
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparams.toJSONString());
		
		Response response = httprequest.request(Method.POST, "/create");
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
	}
	
	@DataProvider(name = "CreateEmployee")
	public String[][] EmpData(){
		String[][] emparr = { {"Shalini", "200000", "41" }, {"Rufus", "500000", "41" } };
		return emparr;
	}

}
