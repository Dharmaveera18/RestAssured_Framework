package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoresEndPoints;

import api.payload.Stores;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StoreTests {

	
	Faker faker;
	User userPayload;
	Stores storePayload;
	
	
	public Logger logger;
	
	@BeforeClass
	public void Setup1()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		faker = new Faker();
		storePayload = new Stores();
		
		storePayload.setId(1);
		storePayload.setPetId(8); // Make sure this pet ID exists
		storePayload.setQuantity(1);
		storePayload.setShipDate("2024-10-28T10:54:41.274+0000");
		
		storePayload.setComplete(true);
		storePayload.setStatus("placed");
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void test_PostOrder()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Creating order ***************************");
		
		Response response = StoresEndPoints.Create_stores_order(storePayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***********  order is created ***************************");
	}
	
	
	@Test(priority = 2)
	public void test_Getorder_ByorderID()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Reading order info ***************************");
		
		Response response = StoresEndPoints.Get_storesOrderbyID(this.storePayload.getId());
				
		response.then().log().all();
		//response.statusCode(); Same
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********** order Info is displayed ***************************");
	}
	
	@Test(priority = 3)
	public void test_Deleteorder_ByOrderID()
	{
		logger.info("***********  Deleting order ***************************");
		
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		Response response = StoresEndPoints.Delete_stores_orderById(this.storePayload.getId());
				
		response.then().log().body();
		//response.statusCode(); Same
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***********  order is Deleted ***************************");
	}
	
}
