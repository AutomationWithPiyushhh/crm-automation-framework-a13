package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLogin {


//	to initialize
	public VtigerLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");

		VtigerLogin vt = new VtigerLogin(driver);

		WebElement un = vt.getUsername();
		WebElement pwd = vt.getPassword();
		WebElement login = vt.getLoginButton();

		driver.navigate().refresh();
		
		un.sendKeys("admin");
		pwd.sendKeys("password");
		login.click();

	}

}
