package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.Stores;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;
	Stores storePayload;
	
	
	public Logger logger;
	
	
	
	
	@BeforeClass
	public void Setup()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void test_PostUser()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Creating user ***************************");
		
		Response response = UserEndpoints.Create_User(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***********  User is created ***************************");
	}
	
	
	@Test(priority = 2)
	public void test_GetUser_ByName()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Reading user info ***************************");
		
		Response response = UserEndpoints.Read_User(this.userPayload.getUsername());
				
		response.then().log().all();
		//response.statusCode(); Same
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********** User Info is displayed ***************************");
	}
	
	
	@Test(priority = 3)
	public void test_UpdateUser_ByName()
	{
		logger.info("***********  Updating user ***************************");
	
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		//Updating the data
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		
		
		Response response = UserEndpoints.Upadte_User(userPayload, this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		//Checking the data after update
		Response responseafterupdate = UserEndpoints.Read_User(this.userPayload.getUsername());
		
		responseafterupdate.then().log().all();
		//response.statusCode(); Same
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
        
		
		logger.info("***********  User is Updated ***************************");
		
		
	}
	
	@Test(priority = 4)
	public void test_DeleteUser_ByName()
	{
		logger.info("***********  Deleting user ***************************");
		
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		Response response = UserEndpoints.Delete_User(this.userPayload.getUsername());
				
		response.then().log().body();
		//response.statusCode(); Same
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***********  User is Deleted ***************************");
	}
	
	
	
	
}
