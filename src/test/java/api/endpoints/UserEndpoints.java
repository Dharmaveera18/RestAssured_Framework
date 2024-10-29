package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import javax.mail.Store;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//UserEndpoints.java it is created for crud operations
//CRUD : ==> [Create, retrieve, Update and Delete]

public class UserEndpoints {

	//Create User
	//To create user we need payload that body
	
	public static Response Create_User(User payload)
	{
		
	
		Response res = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   
		.when()
		    .post(Routes.post_url);
	
		
		return res;
	}
	
	
	public static Response Read_User(String username)
	{
		
	
		Response res = given()
		   .pathParam("username", username)
		  
		   
		.when()
		    .get(Routes.get_url);
	
		System.out.println(res);
		return res;
	}
	
	
	public static Response Upadte_User(User payload, String username)
	{
		
	

		Response res = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   .pathParam("username", username)
		   
		.when()
		    .put(Routes.put_url);
	
		
		return res;
	}
	
	public static Response Delete_User(String username)
	{
		
	
		Response res = given()
		   .pathParam("username", username)
		  
		   
		.when()
		    .delete(Routes.delete_url);
	
		
		return res;
	}
	
	
	
	

}
