package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import api.payload.Pets;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetsEndPoint {

	public static Response Create_Pet(Pets payload)
	{
		
	
		Response res = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   
		.when()
		    .post(Routes.pets_post_url);
	
		
		return res;
	}
	
	
	public static Response Read_Pet(int petid)
	{
		
	
		Response res = given()
		   .pathParam("petid", petid)
		  
		   
		.when()
		    .get(Routes.pets_get_url);
	
		System.out.println(res);
		return res;
	}
	
	
	public static Response Upadte_Pet(Pets payload, int petid)
	{
		
		/*Map<String, Object> formData = new HashMap<>();
	    formData.put("id", 1); // Assuming payload has the ID
	    formData.put("name", "doggie");       // Set name to "doggie"
	    formData.put("status", "available");   // Set status to "available"*/

		Response res = given()
				 .contentType("application/x-www-form-urlencoded") // Set content type for form data
			        .accept(ContentType.JSON) // Accept JSON response
			        .formParam("name", "doggie") // Add form parameter for name
			        .formParam("status", "available") // Add form parameter for status
			        .pathParam("petid", petid) // Set the pet ID
		   
		   
		   
		.when()
		    .post(Routes.pets_post_url1);//Here to Update we have used an Postrequest as per the Swagger document.
	
		
		return res;
	}
	
	public static Response Delete_Pet(int petid)
	{
		
	
		Response res = given()
		   .pathParam("petid", petid)
		  
		   
		.when()
		    
		.delete(Routes.pets_delete_url);
		
		return res;
	}
	
	
	
	
}
