/**
 * Project     : Vtiger CRM Automation
 * Author      : AutomationWithPiyush
 * Version     : 0.0.1
 * Description : This class automates the creation of a new Contact in Vtiger CRM.
 * 
 * It performs the following steps:
 *  1. Launches the browser (Chrome/Edge/Firefox)
 *  2. Logs into the Vtiger CRM application
 *  3. Navigates to Contacts module
 *  4. Creates a new contact by entering the Last Name
 *  5. Validates that the contact is successfully created
 *  6. Logs out and closes the browser
 */

package contact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException {

		// -------------------------------
		// Step 1: Browser Initialization
		// -------------------------------
		String browser = "chrome";   // Hardcoded browser type for execution
		WebDriver driver;

		/**
		 * Launching the appropriate browser based on the given string.
		 * Supports: Chrome, Edge, Firefox
		 */
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Maximize browser window and set implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// -------------------------------
		// Step 2: Login to Application
		// -------------------------------
		driver.get("http://localhost:8888/");

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginBtn = driver.findElement(By.id("submitButton"));

		username.sendKeys("admin");
		password.sendKeys("password");
		loginBtn.submit();

		// -------------------------------
		// Step 3: Navigate to Contacts
		// -------------------------------
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		// -------------------------------
		// Step 4: Fill Contact Form
		// -------------------------------
		WebElement lastName_field = driver.findElement(By.name("lastname"));
		String lastName = "gupta";	// Test data for Last Name field
		lastName_field.sendKeys(lastName);

		// -------------------------------
		// Step 5: Save Contact
		// -------------------------------
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// -------------------------------
		// Step 6: Verification
		// -------------------------------
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		boolean lastNameStatus = actLastName.equals(lastName);

		if (lastNameStatus) {
			System.out.println("Contact created successfully!!!");
		} else {
			System.out.println("Failed to create contact...");
		}

		// -------------------------------
		// Step 7: Logout
		// -------------------------------
		Actions act = new Actions(driver);
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		// -------------------------------
		// Step 8: Close Browser
		// -------------------------------
		Thread.sleep(3000);
		driver.quit();
	}
}
