package TestFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class base {
	
	public Properties prop;
	
	public  void tweet() throws IOException   {
		 
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Qualitest\\RESTAssuredTestProject\\src\\main\\java\\TestFramework\\data.properties");
		prop.load(fis);
}
	
	
	}


