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

package org;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;

public class OrgTest extends BaseClass {

//	public static void main(String[] args) throws InterruptedException, IOException {

	@Test
	public void createOrgTest() throws IOException, InterruptedException {

		String lastName = new FileUtility().getDataFromExcelFile("contact", 5, 0);
		
//		creation
		HomePage hp = new HomePage(driver);

		hp.getContactLink().click();

		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		WebElement lastName_field = driver.findElement(By.name("lastname"));

		lastName_field.sendKeys(lastName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

//		verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(actLastName, lastName);
	}
}
