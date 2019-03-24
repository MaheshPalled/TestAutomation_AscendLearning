package testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AboutPage;
import pages.HomePage;
import testBase.TestBase;


public class AboutPageTestCases extends TestBase {
	public AboutPage AscendLeardningAboutUs;
	public HomePage AscendLearningHomePage;

	@Parameters("driver")
	@BeforeMethod
	public void setUp(Method method, String driver) throws IOException {
		super.setUpBrowser(driver);
		AscendLearningHomePage = new HomePage(Browser);
		AscendLearningHomePage.clickAbout(Browser);
		AscendLeardningAboutUs = new AboutPage(Browser);
		ExtentTester = Reporter.createTest(method.getAnnotation(Test.class).testName());
	}
	
	@AfterMethod
	public void tearDown() {
		Browser.quit();
	}
	
	@Test (priority=1, testName="Verify page header and sub header from about page", suiteName="Regression")
	public void verifyPageHeaderAndSubHeader() {
		AscendLeardningAboutUs.verifyPageHeader();
		AscendLeardningAboutUs.verifyPageSubHeader();
	}
	
	@Test (priority=2, testName="Verify page header and sub header from about page", suiteName="Regression")
	public void verifyTheBlockGridContainer() {
		AscendLeardningAboutUs.verifyBlockGridList("blockGridList", "Nurses", "Medical Assistants", "Pharmacy Technicians", "EMTs", 
				"Fitness Trainers", "Insurance Professionals",
				"Many other Professional Careers");
		AscendLeardningAboutUs.verifyValuePods("We are passionate", "We are selfless", "We are courageous", 
				"We are great listeners", "We embrace change", "We are accountable");
	}
	
	@Test (priority=3, testName="Verify leader present in about page", suiteName="Regression")
	public void verifyLeaderBoard() {
		AscendLeardningAboutUs.verifyLeaderPods("Greg Sebasky", "Larry Gold", "Marty Manning", "Ash Siebecker", "Mandeep Johar", "Jeff Jones",
				"Brian Kelly", "Laurie McCartney", "Ed Moura", "Kim Brophy");
	}
	
	@Test (priority=4, testName="Verify footer links", suiteName="Regression")
	public void verifyFooterLinks() {
		AscendLeardningAboutUs.verifyFooterPrivacy();
		AscendLeardningAboutUs.verifyFooterTerms();
		AscendLeardningAboutUs.verifyFooterLinkedIn();
	}
	
}
