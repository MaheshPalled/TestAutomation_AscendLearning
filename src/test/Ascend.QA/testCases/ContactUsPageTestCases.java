package testCases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactusPage;
import pages.HomePage;
import testBase.TestBase;

public class ContactUsPageTestCases extends TestBase {
	public ContactusPage AscendContactUsPage;
	public HomePage AscendLearningHomePage;
	
	@BeforeMethod
	public void setUp(Method method) throws IOException {
		super.setUpBrowser();
		AscendLearningHomePage = new HomePage(Browser);
		AscendLearningHomePage.clickContctUS();
		AscendContactUsPage = new ContactusPage(Browser);
		ExtentTester = Reporter.createTest(method.getAnnotation(Test.class).testName());
	}
	
	@AfterMethod
	public void tearDown() {
		Browser.close();
	}
	
	@Test (priority=1, testName="verify the contact us text", suiteName="Regression")
	public void verifyPresenceOfHeader() {
		AscendContactUsPage.verifyContactUsHeader();
	}
	
	@Test (priority=2, testName=" verify the presence of MAP in contact us page", suiteName="Regression")
	public void verifyPresenceOfMap() {
		AscendContactUsPage.verifyLocationMap();
	}
	
	@Test (priority=3, testName="Display the list of office location available", suiteName="Regression")
	public void displayOfficeLocation() {
		AscendContactUsPage.displayTheAvailableLocation();
	}
	
}
