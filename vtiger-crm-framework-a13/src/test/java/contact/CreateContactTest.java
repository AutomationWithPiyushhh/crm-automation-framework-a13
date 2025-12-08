/*
 * Project     : Vtiger CRM Automation
 * Author      : AutomationWithPiyush
 * Version     : 0.0.1
 * Description : This class automates the creation of a new Contact in Vtiger CRM.
 *
 * Workflow Summary:
 * 1. Load configuration from properties file
 * 2. Launch browser based on config
 * 3. Log into Vtiger CRM
 * 4. Navigate to Contacts module
 * 5. Create a new contact by entering last name
 * 6. Validate creation
 * 7. Logout and close browser
 */

package contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropertiesFile("browser");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		String lastName = fUtil.getDataFromExcelFile("contact", 5, 0);
		
		// -------------------------------------------
		// Step 1: Browser Initialization
		// -------------------------------------------
		String browser = BROWSER; // Selected browser
		WebDriver driver;

		/*
		 * Launching browser based on value from properties file. Supported browsers:
		 * chrome, edge, firefox
		 */
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			// Default fallback browser
			driver = new ChromeDriver();
		}
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		// Setting browser window and implicit wait
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wdUtil.maximizeWindow();
		wdUtil.waitForPageLoad();
		// -------------------------------------------
		// Step 2: Login into Vtiger CRM
		// -------------------------------------------
		driver.get(URL); // Opening CRM login page

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginBtn = driver.findElement(By.id("submitButton"));

		// Sending credentials
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.submit(); // Logging in

		// -------------------------------------------
		// Step 3: Navigate to Contacts Module
		// -------------------------------------------
		driver.findElement(By.linkText("Contacts")).click();

		// Clicking on Create Contact button
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		// -------------------------------------------
		// Step 4: Fill Contact Form
		// -------------------------------------------
		WebElement lastName_field = driver.findElement(By.name("lastname"));
//        String lastName = "gupta";  // Test data for last name

		// Entering last name
		lastName_field.sendKeys(lastName);

		// -------------------------------------------
		// Step 5: Save the Contact
		// -------------------------------------------
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// -------------------------------------------
		// Step 6: Verification of Contact Creation
		// -------------------------------------------
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		// Validating entered name with displayed name
		boolean lastNameStatus = actLastName.equals(lastName);

		if (lastNameStatus) {
			System.out.println("Contact created successfully!!!");
		} else {
			System.out.println("Failed to create contact...");
		}

		// -------------------------------------------
		// Step 7: Logout from CRM
		// -------------------------------------------
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		// Hovering over profile icon
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();

		wdUtil.hover(profile);
		
		// Clicking Sign Out
		driver.findElement(By.linkText("Sign Out")).click();

		// -------------------------------------------
		// Step 8: Close Browser
		// -------------------------------------------
		Thread.sleep(3000);
		driver.quit();
	}
}
