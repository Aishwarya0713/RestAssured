package TestFramework;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;

import io.restassured.RestAssured;

public class Createtweet1 extends base{
	
	private static Logger log = LogManager.getLogger(Createtweet1.class.getName());
	
@Test
public void getTweet() throws IOException {
	tweet();
	RestAssured.baseURI=prop.getProperty("baseURI");
	Response res = given().auth().oauth(prop.getProperty("Consumerkey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
	queryParam("Count","1").
	when().get("/home_timeline.json").then().extract().response();
	String response =res.asString();
	log.info(response);
	//systemout.println(response);
	JsonPath js = new JsonPath(response);
	String id = js.get("id").toString();
	log.info(id);
	//System.out.println(id);
	String text = js.get("text").toString();
	log.info(text);
	//System.out.println(text);
	
}
	
@Test
public void CreateTweet() throws IOException {
	tweet();
	RestAssured.baseURI=prop.getProperty("baseURI");
	Response res = given().auth().oauth(prop.getProperty("Consumerkey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
	queryParam("status","i am learning API testing using RestAssured Java#Qualitest89").
	when().post("/update.json").then().extract().response();
	
	String response =res.asString();
	log.info(response);
	//System.out.println(response);
	JsonPath js = new JsonPath(response);
	String id = js.get("id").toString();
	log.info(id);
	//System.out.println(id);
	String text = js.get("text").toString();
	log.info(text);
	//System.out.println(text);
	
	
	//given().auth().oauth(Consumerkey,ConsumerSecret,Token,TokenSecret).
	//when().post("/destroy/"+id+".json").then().assertThat().statusCode(200);
	
}

	
}
