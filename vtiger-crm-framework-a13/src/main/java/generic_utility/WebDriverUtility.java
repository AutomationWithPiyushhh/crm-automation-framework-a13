package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	
	WebDriver driver;
	
	public WebDriverUtility(WebDriver driver){
		this.driver = driver;
	}
	
	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
}
