package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(groups = "reg")
	public void case21() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
		System.out.println("21");
	}
	
	@Test(groups = "reg")
	public void case22() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
		System.out.println("22");
	}	

	@Test(groups = "system")
	public void case23() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
		System.out.println("23");
	}
}

