package selenium.extentreports.basic;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport {
	
	ExtentReports extent; // specify the location of the report
	ExtentTest test; // what details should be populated in the report
	ExtentSparkReporter spark;
	
	@BeforeTest
	public void startReport() throws IOException {
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/MySparkReport.html");
		spark.loadXMLConfig(new File(System.getProperty("user.dir") + "/spark-config.xml"));
		spark.config(
				ExtentSparkReporterConfig.builder()
					.theme(Theme.DARK)
					.documentTitle("My Report")
					.reportName("My Report")
					.build()
		);
		//spark.config().setTheme(Theme.STANDARD);
		//spark.config().setDocumentTitle("My First Report");
		//spark.config().setReportName("My Report");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Fernando");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@Test
	public void demoReportPass() {
		test = extent.createTest("demoReportPass");
		Assert.assertTrue(true);
		test.log(Status.PASS, "Assert Pass as condition is True");
	}
	
	@Test
	public void demoReportFail() {
		test = extent.createTest("demoReportFail");
		Assert.assertTrue(false);
		test.log(Status.FAIL, "Assert Fail as condition is False");
	}
	
	@AfterMethod
	public void getResult(ITestResult tr) {
		if(tr.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, tr.getThrowable());
		}
		extent.removeTest(test);
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}

}
