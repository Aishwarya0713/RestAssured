package TestFramework;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;

public class ListAllTweets5 extends base {
	private static Logger log = LogManager.getLogger(ListAllTweets5.class.getName());
	
	@Test
	public void getUserTweets() throws IOException {
		tweet();
		RestAssured.baseURI=prop.getProperty("baseURI");
		Response res = given().auth().oauth(prop.getProperty("Consumerkey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
		when().queryParam("exclude_replies","true").queryParam("include_rts","false").get("user_timeline.json").then().assertThat().statusCode(200).extract().response();
		String response =res.asString();
		log.info(response);
		JsonPath js = new JsonPath(response);
		List<String> a = js.get("text");
		System.out.println(a);
	}

}
