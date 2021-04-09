package TestFramework;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import io.restassured.path.json.JsonPath;
public class  WeatherUpdate4  {
    
	String	Consumerkey="pvcBq3tnJ4wHYJucWtzUbkRTd";
	String	ConsumerSecret="EO0XKwzM9xaYnaFiNQeRFW0pTvaNGSgDrQCby8z4kTEpJFoI9E";
	String	Token="880585208533180416-UYsUkND86REpW8odApDnUwyUs4Zem0T";
	String	TokenSecret="SrpuTJlS4vGJrkN8AHKiwmGxI2Pde8MTSH9VHFfHoiFJO";
            
@Test
public void Weather() {
        
        RestAssured.baseURI="https://api.twitter.com/1.1/search/";
        Response res=given().auth().oauth(Consumerkey,ConsumerSecret,Token,TokenSecret).
        queryParam("q","#Bangalore #Weather").when().
        get("tweets.json").then().extract().response();
        
        String responseString=res.asString();
        JsonPath js=new JsonPath(responseString);
        
        ArrayList<Object> arr=new ArrayList<Object>();
        arr.addAll(js.getList("statuses"));
        Iterator itr=arr.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }               
}

@DataProvider
public Object[][] location() {
    
    Object loc[][]= new Object[4][2];
    loc[0][0]="India";
    loc[0][1]="23424848";
    loc[1][0]="US";
    loc[1][1]="23424977";    
    loc[2][0]="UK";
    loc[2][1]="23424975";    
    loc[3][0]="ISRAEL";    
    loc[3][1]="23424852";    
    return loc;
                        
}
}