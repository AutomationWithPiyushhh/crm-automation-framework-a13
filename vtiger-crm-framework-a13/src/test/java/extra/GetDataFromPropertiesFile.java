package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		step 1>  Get the java representation object of the physical file
//		/vtiger-crm-framework-a13/src/test/resources/commondata.properties
//		modified to
//		./src/test/resources/commondata.properties (. means project level)
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		
//		step 2> load all keys by load(jro) method
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step 3> get the value by getProperty(key) method
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
	}
}
