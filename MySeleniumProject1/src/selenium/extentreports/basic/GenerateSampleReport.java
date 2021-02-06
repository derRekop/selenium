package selenium.extentreports.basic;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateSampleReport {

	@Test
	public void extentTest() {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("spark-index.html");
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("My Automation Report");
		spark.config().setReportName("Extent Report Demo");
		
		extent.attachReporter(spark);
		
		//this is a test node
		ExtentTest test1 = extent.createTest("Login Test").assignAuthor("Fernando").assignCategory("Smoke").assignCategory("Regression").assignDevice("Chrome");
		test1.pass("Login test started successfully");
		test1.info("URL is loaded");
		test1.info("values entered");
		test1.pass("Login test completed successfully");
		
		//this is another test node
		ExtentTest test2 = extent.createTest("Homepage Test").assignAuthor("Antonio").assignCategory("Regression").assignDevice("Firefox").assignAuthor("Jesus");
		test2.pass("Homepage test started successfully");
		test2.info("URL is loaded");
		test2.info("values entered");
		test2.fail("Homepage test failed miserably");
		
		//always call below method at the end of the test
		extent.flush();

	}
}
