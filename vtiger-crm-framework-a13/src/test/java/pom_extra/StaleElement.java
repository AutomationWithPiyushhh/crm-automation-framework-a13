package pom_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElement {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com/");

//		declaration
		WebElement login;

//		initialization
		login = driver.findElement(By.name("login"));

		driver.navigate().refresh();

//		re-initialization
		login = driver.findElement(By.name("login"));
//		utilization
		login.click();

		Thread.sleep(3000);
		driver.quit();
	}
}
