package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		try {
			String screenShotName = WebDriverUtility.takeScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenShotName);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Whistle Automation Extent Report");
		spark.config().setDocumentTitle("Whistle Automation Test Report - WS001");

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "Test_Automation_Virtual_Machine");
		report.setSystemInfo("serverName", "Ubuntu");
	}

	public void onFinish(ITestContext context) {
		report.flush();	
	}
}
