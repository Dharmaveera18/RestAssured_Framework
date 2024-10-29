package api.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Category;
import com.github.javafaker.Faker;

import api.endpoints.PetsEndPoint;
import api.payload.Pets;
import api.payload.Stores;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetTests {

	Faker faker;
	User userPayload;
	Stores storePayload;
	Pets petspayload;
	
	public Logger logger;
	
	
	
	
	@BeforeClass
	public void Setup()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		
		faker = new Faker();
		petspayload = new Pets();
		
		
		// Create a list and add a URL
		List<String> photoUrls = new ArrayList<>();
		photoUrls.add("http://example.com/photo1.jpg");
		photoUrls.add("http://example.com/photo2.jpg");

		// Set the photoUrls
		//pet.setPhotoUrls(photoUrls);
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag()); // Example tag
		tags.add(new Tag()); // Another example tag

		// Set the tags for the pet
		
		
		petspayload.setId(1);
		petspayload.setCategory(new Category("Dog Breed"));
		petspayload.setName("Tommy");
		petspayload.setPhotoUrls(photoUrls);
		petspayload.setTags(tags);
		petspayload.setStatus("available");
		
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void test_PostPet()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Creating pet ***************************");
		
		Response response = PetsEndPoint.Create_Pet(petspayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***********  pet is created ***************************");
	}
	
	
	@Test(priority = 2)
	public void test_GetPet_ByID()
	{
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Reading pet info ***************************");
		
		Response response = PetsEndPoint.Read_Pet(this.petspayload.getId());
				
		response.then().log().all();
		//response.statusCode(); Same
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********** pet Info is displayed ***************************");
	}
	
	
	
	
	@Test(priority = 3)
	public void test_UpdatePet_ByID()
	{
		
	
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		//petspayload = new Pets();
		
		logger.info("***********  Updating pet ***************************");
		// Ensure petspayload is initialized
		if (petspayload == null) {
		    petspayload = new Pets();
		    petspayload.setId(1); // Set the ID to the correct value
		    petspayload.setName("Jimmy");
		    petspayload.setStatus("available");
		}
		
		
		
		Response response = PetsEndPoint.Upadte_Pet(petspayload, this.petspayload.getId());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		//Checking the data after update
		Response responseafterupdate = PetsEndPoint.Read_Pet(this.petspayload.getId());
		
		responseafterupdate.then().log().all();
		//response.statusCode(); Same
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
        
		
		logger.info("***********  pet is Updated ***************************");
		
		
	}
	
	
	
	
	@Test(priority = 4)
	public void test_DeletePet_ByID()
	{
		
		
		RestAssured.useRelaxedHTTPSValidation();  //To Handlw Auth
		logger.info("***********  Deleting pet ***************************");
		
		Response response = PetsEndPoint.Delete_Pet(this.petspayload.getId());
				
		response.then().log().body();
		//response.statusCode(); Same
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***********  pet is Deleted ***************************");
	}
	
	
	
	
	
	
	
	
}
