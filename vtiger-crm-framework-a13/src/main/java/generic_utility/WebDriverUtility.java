package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains reusable WebDriver utility methods such as window
 * management, waits, dropdown selections, mouse and keyboard interactions. It
 * also includes additional utilities such as alerts, scrolling, screenshot, JS
 * execution, drag-drop, sliders, and more.
 * 
 * @version 2.0
 * 
 *  
 * @author Piyush Baldaniya
 */
public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	} 

	/**
	 * Maximizes the browser window.
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	
	/* to handle frames */
	
	public void frame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void frame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void frame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void parentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public void mainFrame() {
		driver.switchTo().defaultContent();
	}

	
	// ===== Basic Waits =====

	/**
	 * Applies implicit wait for the page to load.
	 */
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * Waits explicitly until the element is visible.
	 * 
	 * @param element        WebElement to wait for
	 */
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Waits explicitly until the element is clickable.
	 * 
	 * @param element        WebElement to wait for
	 * @param timeOutSeconds Max wait time in seconds
	 */
	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Waits explicitly until an element is invisible.
	 * 
	 * @param element        WebElement to wait for invisibility
	 * @param timeOutSeconds Max wait time in seconds
	 */
	public void waitForElementInvisibility(WebElement element, int timeOutSeconds) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Waits explicitly for specific text to be present in an element.
	 * 
	 * @param element        WebElement
	 * @param text           Expected text
	 * @param timeOutSeconds Max wait time in seconds
	 */
	public void waitForTextInElement(WebElement element, String text, int timeOutSeconds) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}


	/**
	 * Waits for the page title to contain given text.
	 * 
	 * @param titlePart      Partial or full title text
	 * @param timeOutSeconds Max wait time in seconds
	 */
	public void waitForTitleContains(String titlePart, int timeOutSeconds) {
		wait.until(ExpectedConditions.titleContains(titlePart));
	}

	/**
	 * Waits for the URL to contain given text.
	 * 
	 * @param urlFraction    Partial or full URL text
	 * @param timeOutSeconds Max wait time in seconds
	 */
	public void waitForUrlContains(String urlFraction, int timeOutSeconds) {
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	// ===== Dropdown Select Methods =====

	/**
	 * Selects dropdown option by index.
	 * 
	 * @param element The dropdown WebElement
	 * @param index   Index of the option
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * Selects dropdown option by value.
	 * 
	 * @param element The dropdown WebElement
	 * @param value   Value of the option
	 */
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * Selects dropdown option by visible text.
	 * 
	 * @param visibleText Text visible in dropdown
	 * @param element     The dropdown WebElement
	 */
	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	// ===== Basic Mouse Actions =====

	/**
	 * Performs mouse hover on the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	/**
	 * Performs right-click on the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	/**
	 * Performs double-click on the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void doubleClickOnElement(WebElement element) {
		act.doubleClick(element).perform();
	}

	/**
	 * Clicks and holds the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).perform();
	}

	/**
	 * Drags source element and drops onto target element.
	 * 
	 * @param source Source element to drag
	 * @param target Target element to drop onto
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).perform();
	}

	/**
	 * Moves slider input element by offset.
	 * 
	 * @param slider  WebElement slider
	 * @param xOffset Horizontal offset to move
	 */
	public void moveSliderByOffset(WebElement slider, int xOffset) {
		act.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
	}

	// ===== Scroll Methods =====

	/**
	 * Scrolls the page to bring the element into view.
	 * 
	 * @param element WebElement to scroll into view
	 */
	public void scrollIntoView(WebElement element, boolean bool) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView("+ bool +");", element);
	}

	/**
	 * Scrolls by the given X and Y offset.
	 * 
	 * @param x Horizontal scroll
	 * @param y Vertical scroll
	 */
	public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
//													"window.scrollBy(0,1000)"
	}

	// ===== Basic Element Interactions =====

	/**
	 * Waits for an element to be clickable and clicks it.
	 * 
	 * @param element        WebElement to click
	 * @param timeoutSeconds Max wait time before clicking
	 */
	public void waitAndClick(WebElement element) {
		waitForElementClickable(element);
		element.click();
	}

	/**
	 * Sends keys to an element after clearing existing text.
	 * 
	 * @param element WebElement input
	 * @param text    Text to send
	 */
	public void clearAndSendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Sends keyboard key to element.
	 * 
	 * @param element WebElement input or focusable
	 * @param key     Keyboard key (Keys.ENTER, Keys.TAB, etc)
	 */
	public void sendKeyboardKey(WebElement element, Keys key) {
		element.sendKeys(key);
	}

	// ===== Browser Navigation Utilities =====

	/**
	 * Navigates back in browser history.
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * Navigates forward in browser history.
	 */
	public void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * Refreshes the current page.
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// ===== Checkbox and Radio Button Handling =====

	/**
	 * Checks a checkbox if not already checked.
	 * 
	 * @param checkbox The checkbox WebElement
	 */
	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Unchecks a checkbox if it is currently checked.
	 * 
	 * @param checkbox The checkbox WebElement
	 */
	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Selects a radio button if not already selected.
	 * 
	 * @param radioButton The radio button WebElement
	 */
	public void selectRadioButton(WebElement radioButton) {
		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}


	// ===== Screenshot Methods =====

	/**
	 * Takes screenshot and stores with given name.
	 * 
	 * @param screenshotName Name * @param screenshotName Name
	 * @throws IOException if file write fails
	 */
	public void takeScreenshot(String screenshotName) throws IOException {
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./screenshots/" + screenshotName + ".png");
		
		FileHandler.copy(src, dest);
	}

	/**
	 * Takes screenshot with timestamp appended to the name.
	 * 
	 * @param baseName Base name of the screenshot file
	 * @throws IOException if file write fails
	 */
	public void takeScreenshotWithTimestamp(String baseName) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		String timestamp = DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy").format(now);
		takeScreenshot(baseName + "_" + timestamp);
	}

// ===== Alert Handling =====

	/**
	 * Accepts alert popup.
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * Dismisses alert popup.
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Returns alert text.
	 * 
	 * @return Alert text
	 */
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * Sends text to alert prompt.
	 * 
	 * @param text Text to send
	 */
	public void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

// ===== JavaScript Executor Methods =====

	/**
	 * Executes JavaScript to click an element.
	 * 
	 * @param element WebElement to click
	 */
	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	/**
	 * Executes JavaScript to set value of an element.
	 * 
	 * @param element WebElement to set value
	 * @param value   Value to set
	 */
	public void jsSetValue(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	}

	/**
	 * Scrolls the page down to the bottom using JavaScript.
	 */
	public void jsScrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * Scrolls the page up to the top using JavaScript.
	 */
	public void jsScrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}

// ===== Window and Tab Handling =====

	/**
	 * Switches to a window/tab by title.
	 * 
	 * @param partialWindowTitle Partial or full window title
	 */
	public void switchToWindowByTitle(String partialWindowTitle) {
		Set<String> IDs = driver.getWindowHandles();
		for (String i : IDs) {
			driver.switchTo().window(i);

			String title = driver.getTitle();
			if (title.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * Switches to the window/tab by URL.
	 * 
	 * @param partialUrl Partial or full URL
	 */
	public void switchToWindowByUrl(String partialUrl) {
		Set<String> IDs = driver.getWindowHandles();
		for (String i : IDs) {
			driver.switchTo().window(i);
			String url = driver.getCurrentUrl();
			if (url.contains(partialUrl)) {
				break;
			}
		}
	}


	/**
	 * Closes all windows except parent.
	 * 
	 * @param parentWindowHandle Window handle of the parent
	 * @throws InterruptedException 
	 */
	public void closeAllChildWindows(String parentWindowHandle) throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}
}