package services;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ServicesTest {
	
	final static String ROOT_URI = "https://restcountries.eu/rest/v2/alpha/";
	
	public void verifyCountry(String id) throws Exception {
		
		String URI = ROOT_URI+id;
		
		InputStream input = new FileInputStream("src/test/java/resources/framework.properties");
		Properties prop = new Properties();
        prop.load(input);
        String Cname = prop.getProperty(id);
        String Ccapital = prop.getProperty(id+"capital");
		
		Response response = get(URI);
		response.then()
	      		.assertThat()
	      		.statusCode(200)
	      		.body("alpha2Code", Matchers.is(id))
	      		.body("name", Matchers.is(Cname))
	      		.body("capital", Matchers.is(Ccapital));
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String alpha2Code = jsonPathEvaluator.get("alpha2Code");
		String name = jsonPathEvaluator.get("name");
		String capital = jsonPathEvaluator.get("capital");
		
		System.out.println("\nTesting service : "+ROOT_URI+id+"\nCountry received : "+alpha2Code+"\nCountry Name : "+name+"\n"+"Country Capital : "+capital+"\n");
		
	}
	
	public void verifyInexistentCountry(String id) throws Exception {
		
		String URI = ROOT_URI+id;
		
		Response response = get(URI);
		response.then()
	      		.assertThat()
	      		.statusCode(404)
	      		.body("message", Matchers.is("Not Found"));
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String message = jsonPathEvaluator.get("message");
		
		System.out.println("\nTesting service : "+ROOT_URI+id+"\nMessage received : "+message+"\n");

	}
	
	public void verifyCreateCountry(String country, String alpha2, String alpha3) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\"name\": \""+country+",\"alpha2_code\": \""+alpha2+",\"alpha3_code\": \""+alpha3+"\"}")
				.when()
				.post(ROOT_URI+"create");
		
		System.out.println("POST Response\n" + response.asString());
		
		response.then().body("name", Matchers.is(country));
		response.then().body("alpha2_code", Matchers.is(alpha2));
		response.then().body("alpha3_code", Matchers.is(alpha3));
	}

}
