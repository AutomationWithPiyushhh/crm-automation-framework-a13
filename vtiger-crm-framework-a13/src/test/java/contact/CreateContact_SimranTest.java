/**
 * Author  : AutomationWithPiyush
 * Test    : Create Contact - Simran Verma
 * Version : 1.0
 */
package contact;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact_SimranTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // -------------------------------
        // Step 1: Browser Setup
        // -------------------------------
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // -------------------------------
        // Step 2: Login
        // -------------------------------
        driver.get("http://localhost:8888/");

        // --- Replace these locators with your actual ones ---
        driver.findElement(By.name("user_name")).sendKeys("admin");  
        driver.findElement(By.name("user_password")).sendKeys("password");
        driver.findElement(By.id("submitButton")).click();

        // -------------------------------
        // Step 3: Navigate to Contacts
        // -------------------------------
        driver.findElement(By.linkText("Contacts")).click();

        // --- Replace createContactBtn locator ---
        driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

        // -------------------------------
        // Step 4: Fill Contact Form
        // -------------------------------
        driver.findElement(By.name("firstname")).sendKeys("Simran");
        driver.findElement(By.name("lastname")).sendKeys("Verma");

        driver.findElement(By.name("account_name")).sendKeys("HP");  
        driver.findElement(By.name("leadsource")).sendKeys("Referral");
        driver.findElement(By.name("department")).sendKeys("IT");

        driver.findElement(By.id("email")).sendKeys("simran.verma@xyz.com");
        driver.findElement(By.id("mobile")).sendKeys("9876345012");
        driver.findElement(By.id("phone")).sendKeys("080554433");

        // Assigned To – User
        driver.findElement(By.xpath("//input[@value='U']")).click();
        driver.findElement(By.name("assigned_user_id")).sendKeys("Admin");

        // -------------------------------
        // Step 5: Save
        // -------------------------------
        driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

        // -------------------------------
        // Step 6: Verification
        // -------------------------------
        // Replace this locator too
        String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

        if (actLastName.equals("Verma")) {
            System.out.println("SUCCESS: Contact 'Simran Verma' created!");
        } else {
            System.out.println("FAILURE: Contact not created!");
        }

        // -------------------------------
        // Step 7: Logout
        // -------------------------------
        Actions action = new Actions(driver);
        WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        action.moveToElement(profile).perform();

        driver.findElement(By.linkText("Sign Out")).click();

        // -------------------------------
        // Step 8: Close Browser
        // -------------------------------
        Thread.sleep(2000);
        driver.quit();
    }
}

