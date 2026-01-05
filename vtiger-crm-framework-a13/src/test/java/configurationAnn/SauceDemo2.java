package configurationAnn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemo2 {

	public WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		// Launches Chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void login() {
		// Direct Navigation
		driver.get("https://www.saucedemo.com/");

		// Login Logic (Directly interacting with elements)
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Logged in successfully");
	}

	@Test
	public void addToCart() throws InterruptedException {
		// Add to cart
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

		// Verify
		boolean status = driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).isDisplayed();
		if (status) {
			System.out.println("Condition Met: Successfully added to the cart");
		}
	}

	@AfterMethod
	public void logOut() {
		// SauceDemo Logout logic: Open menu then click logout
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Logged out successfully");
	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed");
		}
	}
}