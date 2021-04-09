package TestFramework;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import io.restassured.path.json.JsonPath;
public class BlockUser8 extends base {
	String	Consumerkey="pvcBq3tnJ4wHYJucWtzUbkRTd";
	String	ConsumerSecret="EO0XKwzM9xaYnaFiNQeRFW0pTvaNGSgDrQCby8z4kTEpJFoI9E";
	String	Token="880585208533180416-UYsUkND86REpW8odApDnUwyUs4Zem0T";
	String	TokenSecret="SrpuTJlS4vGJrkN8AHKiwmGxI2Pde8MTSH9VHFfHoiFJO";
	            
	
	@Test
    public void block_user() throws IOException {
        RestAssured.baseURI="https://api.twitter.com/1.1/blocks/";
        Response res=given().auth().oauth(Consumerkey,ConsumerSecret,Token,TokenSecret).
        queryParam("id","1365152181725188101").when().post("create.json").then().extract().response();
        String response=res.asString();
        JsonPath jp=new JsonPath(response);
        String name=jp.get("name");
        System.out.println(name);
    }

}
