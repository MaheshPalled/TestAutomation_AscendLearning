package testBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Utility;

public class TestBase {
	public static WebDriver Browser;
	public static ExtentHtmlReporter HtmlReporter;
	public static ExtentReports Reporter;
	public static ExtentTest ExtentTester;
	
	public static void setUpBrowser() throws IOException {
		String driver = Utility.getMyValue("driver");
		String navUrl = Utility.getMyValue("navigationURL");
		switch(driver) {
		case "Chrome":
			Browser = new ChromeDriver();
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

	
	@AfterSuite
	public void reportUpdate() {
		Reporter.flush();
	}
	
}
