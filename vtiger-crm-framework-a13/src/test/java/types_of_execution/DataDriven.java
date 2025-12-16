package types_of_execution;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDriven {
	
	@Parameters({"bro","un","pwd"})
	
	@Test
	public void commonData(String browser, String username, String password) {
//		String browser = "chrome";

		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}
}

