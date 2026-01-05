/*
 * Project     : Vtiger CRM Automation
 * Author      : AutomationWithPiyush
 * Version     : 0.0.1
 *
 * Description :
 * This test class automates the creation of a new Contact in the Vtiger CRM application.
 * It validates whether the contact is successfully created by comparing the entered
 * last name with the last name displayed on the contact details page.
 *
 * Workflow Summary:
 * 1. Read test data from Excel file
 * 2. Launch browser and login (handled by BaseClass)
 * 3. Navigate to Contacts module
 * 4. Create a new contact using provided test data
 * 5. Save the contact
 * 6. Verify the created contact details
 * 7. Logout and close browser (handled by BaseClass)
 */

package crm.vtiger.web.contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;

public class ContactTest extends BaseClass {

	/**
	 * Test Case: createContactTest
	 *
	 * Description: This test method creates a new contact in Vtiger CRM by entering
	 * a last name fetched from an Excel file and validates its successful creation.
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void createContactTest() throws IOException, InterruptedException {

		// Fetch test data (Last Name) from Excel file
		String lastName = new FileUtility().getDataFromExcelFile("contact", 5, 0);

		// Create HomePage object using Page Object Model
		HomePage hp = new HomePage(driver);

		// Navigate to Contacts module
		hp.getContactLink().click();

		// Click on "Create Contact" icon
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		// Locate Last Name input field
		WebElement lastName_field = driver.findElement(By.name("lastname"));

		// Enter Last Name into the field
		lastName_field.sendKeys(lastName);

		// Click on Save button to create contact
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// Fetch actual Last Name displayed on contact details page
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		// Validate that the contact is created with correct Last Name
		Assert.assertEquals(actLastName, lastName, "Contact creation failed: Last Name mismatch");
	}
}
