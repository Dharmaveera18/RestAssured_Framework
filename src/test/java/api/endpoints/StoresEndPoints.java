package api.endpoints;

import static io.restassured.RestAssured.given;



import api.payload.Stores;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoresEndPoints {

	
	
	//Stores Endpoints
	
		public static Response Create_stores_order(Stores storePayload)
		{
			
		
			Response res = given()
			   .contentType(ContentType.JSON)
			   .accept(ContentType.JSON)
			   .body(storePayload)
			   
			.when()
			    .post(Routes.stores_post_url);
		
			
			return res;
		}
		
		
		public static Response Get_storesOrderbyID(int orderid)
		{
			
		
			Response res = given()
			   .pathParam("orderid", orderid)
			  
			   
			.when()
			    .get(Routes.stores_get_url);
		
			System.out.println(res);
			return res;
		}
		
		
		public static Response Delete_stores_orderById(int orderid)
		{
			
		
			Response res = given()
			   .pathParam("orderid", orderid)
			  
			   
			.when()
			    .delete(Routes.stores_delete_url);
		
			
			return res;
		}
	
	
	
	
	
}
