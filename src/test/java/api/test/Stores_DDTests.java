package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StoresEndPoints;
import api.endpoints.UserEndpoints;
import api.payload.Stores;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Stores_DDTests {

	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void test_PostOrder(String id, String petID, String Quantity, String shipDate, String Status, String complete)
	{

		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		Stores storePayload = new Stores();
	    storePayload.setId(Integer.parseInt(id));
	    storePayload.setPetId(Integer.parseInt(petID));
	    storePayload.setQuantity(Integer.parseInt(Quantity));
	    storePayload.setShipDate(shipDate);
	    storePayload.setStatus(Status);
	    storePayload.setComplete(Boolean.parseBoolean(complete)); // Convert String to boolean
		
		
		Response response = StoresEndPoints.Create_stores_order(storePayload);
		
		//response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteOrderByID(String id)
	{
		Response response = StoresEndPoints.Delete_stores_orderById(Integer.parseInt(id));
       // response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
}
