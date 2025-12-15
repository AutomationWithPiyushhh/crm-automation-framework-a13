package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo3 {
	@Test(groups = "reg")
	public void case31() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}
	
	@Test(groups = "smoke")
	public void case32() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}	

	@Test(groups = "smoke")
	public void case33() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}
}

