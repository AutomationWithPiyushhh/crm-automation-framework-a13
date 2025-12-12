package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 5)
	public void case1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(invocationCount = 0)
	public void case2() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(invocationCount = 10, threadPoolSize = 5)
	public void case21() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(alwaysRun = true)
	public void case3() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(500);
		driver.quit();
	}
	
	@Test(invocationCount = 5, threadPoolSize = 5,enabled = false)
	public void case4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}
	
	
	@Test(alwaysRun = true,enabled = false)
	public void case5() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(500);
		driver.quit();
	}
	
}
