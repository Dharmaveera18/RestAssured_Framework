package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DDTests {

	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void test_PostUser(String userID, String userName, String fname, String lname, String UserEmail, String pwd, String phone)
	{

		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(UserEmail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		
		
		Response response = UserEndpoints.Create_User(userPayload);
		
		//response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserbyName(String userName)
	{
		Response response = UserEndpoints.Delete_User(userName);
       // response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
