/*
 * Project     : Vtiger CRM Automation
 * Author      : AutomationWithPiyush
 * Version     : 0.0.1
 *
 * Description :
 * This test class automates the creation and verification of an entity
 * in the Vtiger CRM application using Selenium WebDriver and TestNG.
 *
 * Note:
 * Although the class name suggests Organization testing, the current
 * implementation validates the Contact creation flow.
 * (Can be easily extended/refactored for Organization module.)
 *
 * Workflow Summary:
 * 1. Read test data from Excel file
 * 2. Launch browser and login (handled by BaseClass)
 * 3. Navigate to Contacts module
 * 4. Create a new contact using test data
 * 5. Save the record
 * 6. Validate successful creation
 * 7. Logout and close browser (handled by BaseClass)
 */

package crm.vtiger.web.org;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;

public class OrgTest extends BaseClass {

	/**
	 * Test Case: createOrgTest
	 *
	 * Description:
	 * This test method reads test data from an Excel file,
	 * performs creation of a CRM record, and verifies that
	 * the entered data is correctly saved and displayed.
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void createOrgTest() throws IOException, InterruptedException {

		// Fetch test data (Last Name) from Excel file
		String lastName = new FileUtility().getDataFromExcelFile("contact", 5, 0);

		// Initialize HomePage object using Page Object Model
		HomePage hp = new HomePage(driver);

		// Navigate to Contacts module from Home page
		hp.getContactLink().click();

		// Click on "Create Contact" button/icon
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		// Locate the Last Name input field
		WebElement lastName_field = driver.findElement(By.name("lastname"));

		// Enter Last Name into the input field
		lastName_field.sendKeys(lastName);

		// Click on Save button to submit the form
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// Capture the actual Last Name displayed after creation
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		// Assert to verify record creation with correct data
		Assert.assertEquals(
				actLastName,
				lastName,
				"Record creation failed: Last Name mismatch"
		);
	}
}
