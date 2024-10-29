package api.endpoints;


//Petstore Swaggers ==> Users ==> Module/Model

//Swagger Uri ==> https://petstore.swagger.io/

//Create User ==>https://petstore.swagger.io/v2/user

//Get User ==>https://petstore.swagger.io/v2/user/{{user_Name}}

//Update User ==>https://petstore.swagger.io/v2/user/{{user_Name}}

//delete User ==>https://petstore.swagger.io/v2/user/{{user_Name}}



public class Routes {

	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User module URLs
	
	public static String post_url = base_url + "/user";
	
	public static String get_url = base_url + "/user/{username}";
	
	public static String put_url = base_url + "/user/{username}";
	
	public static String delete_url = base_url + "/user/{username}";
	
	
	//Store module URLs
	
    public static String stores_post_url = base_url + "/store/order";
	
	public static String stores_get_url = base_url + "/store/order/{orderid}";
	
	public static String stores_delete_url = base_url + "/store/order/{orderid}";
	
	
	
	
	
	
	
	
	   //
	//Pet module URLs
    public static String pets_post_url = base_url + "/pet";
	
	public static String pets_get_url = base_url + "/pet/{petid}";
	
	public static String pets_post_url1 = base_url + "/pet/{petid}";
	
	public static String pets_delete_url = base_url + "/pet/{petid}";
	
	
	
}
