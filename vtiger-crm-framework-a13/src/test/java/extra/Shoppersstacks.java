package extra;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shoppersstacks {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://shoppersstack.com/products_page/25");

		Thread.sleep(15000);

//		step 1> get the home address
		String PID = driver.getWindowHandle();

//		Step 2> perform the task which will open the new window/s
		driver.findElement(By.id("compare")).click();

		Set<String> IDs = driver.getWindowHandles();
		for (String i : IDs) {
			driver.switchTo().window(i);

			String title = driver.getTitle();
			if (title.contains("amazon")) {
				break;
			}
		}
		
//		WebDriverUtility wdUtil = new WebDriverUtility(driver);
//		
//		wdUtil.switchToWindowByTitle("amazon");
		
//		step 5> perform the task in child window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();

//		step 6> come back to home
		driver.switchTo().window(PID);

		Thread.sleep(3000);
		driver.quit();

	}
}
