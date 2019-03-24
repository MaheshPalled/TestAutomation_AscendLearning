package testBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Utility;

public class TestBase {
	public static WebDriver Browser;
	public static ExtentHtmlReporter HtmlReporter;
	public static ExtentReports Reporter;
	public static ExtentTest ExtentTester;
	
	
	public static void setUpBrowser(String driver) throws IOException {
		String navUrl = Utility.getMyValue("navigationURL");
		if(driver.equalsIgnoreCase("Chrome")) {
			Browser = new ChromeDriver();
			Browser.get(navUrl);
			Browser.manage().window().fullscreen();
		}
		else if (driver.equalsIgnoreCase("Safari")){
			Browser = new SafariDriver();
			Browser.get(navUrl);
			Browser.manage().window().fullscreen();
		}
	}
	
	@BeforeSuite()
	public void reportSetUp() {
		HtmlReporter= new ExtentHtmlReporter("ExtentTestReport.html");
		Reporter = new ExtentReports();
		Reporter.attachReporter(HtmlReporter);
	}

	@BeforeTest()
	public void testReport(){
		HtmlReporter.setAppendExisting(true);
	}
	
	@AfterTest()
	public void addTestReport(){
	
	}
	
	
	@AfterSuite
	public void reportUpdate() {
	}
	
}
