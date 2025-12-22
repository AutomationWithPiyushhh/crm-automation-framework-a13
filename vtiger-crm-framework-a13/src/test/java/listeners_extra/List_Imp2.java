package listeners_extra;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class List_Imp2 implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		String time = JavaUtility.genCurrentTime();

		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/" + time + ".html");

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

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		System.out.println(methodName + " started executing...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Failed...");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Skipped...");
	}
}
