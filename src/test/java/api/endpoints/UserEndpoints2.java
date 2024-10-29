package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import javax.mail.Store;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//UserEndpoints.java it is created for crud operations
//CRUD : ==> [Create, retrieve, Update and Delete]

public class UserEndpoints2 {

	//Create User
	//To create user we need payload that body
	
	
	//Method cretaed to get the URLs from the properties file
	public static ResourceBundle testURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("Routes");
		
		return routes;
	}
	
	
	
	
	public static Response Create_User(User payload)
	{
		
		
		  String post_url = testURL().getString("post_url");
	
		Response res = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   
		.when()
		    .post(post_url);
	
		
		return res;
	}
	
	
	public static Response Read_User(String username)
	{
		String get_url = testURL().getString("get_url");
	
		Response res = given()
		   .pathParam("username", username)
		  
		   
		.when()
		    .get(get_url);
	
		System.out.println(res);
		return res;
	}
	
	
	public static Response Upadte_User(User payload, String username)
	{
		String put_url = testURL().getString("put_url");
	

		Response res = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   .pathParam("username", username)
		   
		.when()
		    .put(put_url);
	
		
		return res;
	}
	
	public static Response Delete_User(String username)
	{
		String delete_url = testURL().getString("delete_url");
	
		Response res = given()
		   .pathParam("username", username)
		  
		   
		.when()
		    .delete(delete_url);
	
		
		return res;
	}
	
	
	
	

}
