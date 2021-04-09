package TestFramework;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import io.restassured.path.json.JsonPath;

public class UsernameTweetText3 extends base{
    
	String	Consumerkey="pvcBq3tnJ4wHYJucWtzUbkRTd";
	String	ConsumerSecret="EO0XKwzM9xaYnaFiNQeRFW0pTvaNGSgDrQCby8z4kTEpJFoI9E";
	String	Token="880585208533180416-UYsUkND86REpW8odApDnUwyUs4Zem0T";
	String	TokenSecret="SrpuTJlS4vGJrkN8AHKiwmGxI2Pde8MTSH9VHFfHoiFJO";
	
    @Test
    public void displayusername_tweet() throws IOException {
        
        RestAssured.baseURI="https://api.twitter.com/1.1/search/";
        Response res=given().auth().oauth(Consumerkey,ConsumerSecret,Token,TokenSecret).
                queryParam("q", "#Qualitest").when().
                get("tweets.json").then().extract().response();
        String response=res.asString();
        JsonPath jp=new JsonPath(response);

 

        
        ArrayList<Object> arr=new ArrayList<Object>();
        ArrayList<Object> arr1=new ArrayList<Object>();
        arr.addAll(jp.getList("statuses.text"));
        arr1.addAll(jp.getList("statuses.user.name"));
    
        Iterator itr=arr.iterator();
        Iterator itr1=arr1.iterator();
        
        while(itr.hasNext())
        {        
            System.out.println("Tweet:"+itr.next()+" UserName"+itr1.next());
        }
    
}
}