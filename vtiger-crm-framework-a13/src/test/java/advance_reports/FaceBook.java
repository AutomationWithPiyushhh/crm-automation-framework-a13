package advance_reports;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class FaceBook {

	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
//		configuration
		
		String time = JavaUtility.genCurrentTime();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/"+time+".html");
//															 ./reports/18122025_164618.html	

		spark.config().setDocumentTitle("Facebook Reports");
		spark.config().setReportName("Initial Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();

		report.attachReporter(spark);

		report.setSystemInfo("browser", "chromium");
		report.setSystemInfo("OS", "window");
		report.setSystemInfo("version", "11");
		report.setSystemInfo("ATE", "automationWithPiyush");
	}

	@Test
	public void instalogin() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.instagram.com/");

//		report generate
		ExtentTest test = report.createTest("instalogin");
		test.log(Status.INFO, "This is just information");

		TakesScreenshot tks = (TakesScreenshot) driver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(ss);

		driver.quit();
	}

	@Test
	public void fblogin() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.facebook.com/");

//		report generate
		ExtentTest test = report.createTest("fblogin");
		test.log(Status.INFO, "This is just information");

		TakesScreenshot tks = (TakesScreenshot) driver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(ss);

		driver.quit();
	}

	@AfterSuite
	public void repBackup() {
//		backup
		report.flush();
	}

}
