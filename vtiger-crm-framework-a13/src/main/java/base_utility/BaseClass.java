package base_utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeClass
	public void openBro() throws IOException {
		String browser = new FileUtility().getDataFromPropertiesFile("browser");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			// Default fallback browser
			driver = new ChromeDriver();
		}

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.maximizeWindow();
		wdUtil.waitForPageLoad();
	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();

		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);

		WebElement username = lp.getUsername();
		WebElement password = lp.getPassword();
		WebElement loginBtn = lp.getLoginButton();

		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.submit(); 
	}

	@AfterMethod
	public void logOut() {
		WebElement profile = new HomePage(driver).getProfileIcon();
		new WebDriverUtility(driver).hover(profile);
		new HomePage(driver).getSignOutLink().click();
	}

	@AfterClass
	public void closeBro() throws InterruptedException {
		driver.quit();
	}
}
