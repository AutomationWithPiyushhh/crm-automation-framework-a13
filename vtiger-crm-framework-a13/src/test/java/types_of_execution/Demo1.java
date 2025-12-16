package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	@Test(groups = "smoke")
	public void case11() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
		System.out.println("11");
	}
	
	@Test(groups = "reg")
	public void case12() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
		System.out.println("12");
	}	

	@Test(groups = "reg")
	public void case13() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
		System.out.println("13");
	}
}

