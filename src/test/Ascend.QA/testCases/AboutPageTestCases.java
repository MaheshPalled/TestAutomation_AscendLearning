package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AboutPage;
import pages.HomePage;
import testBase.TestBase;

public class AboutPageTestCases extends TestBase {
	public AboutPage AscendLeardningAboutUs;
	public HomePage AscendLearningHomePage;
	
	public AboutPageTestCases() throws IOException {
		
	}

	@BeforeMethod
	public void setUp() throws IOException {
		super.setUpBrowser();
		AscendLearningHomePage = new HomePage(Browser);
		AscendLearningHomePage.clickAbout(Browser);
		AscendLeardningAboutUs = new AboutPage(Browser);
	}
	
	@AfterMethod
	public void tearDown() {
		Browser.manage().deleteAllCookies();
		Browser.quit();
	}
	
	@Test (priority=1, testName="Verify page header and sub header from about page")
	public void verifyPageHeaderAndSubHeader() {
		AscendLeardningAboutUs.verifyPageHeader();
		AscendLeardningAboutUs.verifyPageSubHeader();
	}
	
	@Test (priority=2, testName="Verify page header and sub header from about page")
	public void verifyTheBlockGridContainer() {
		AscendLeardningAboutUs.verifyBlockGridList("blockGridList", "Nurses", "Medical Assistants", "Pharmacy Technicians", "EMTs", 
				"Fitness Trainers", "Insurance Professionals",
				"Many other Professional Careers");
		AscendLeardningAboutUs.verifyValuePods("We are passionate", "We are selfless", "We are courageous", 
				"We are great listeners", "We embrace change", "We are accountable");
	}
	
	@Test (priority=3, testName="Verify leader present in about page")
	public void verifyLeaderBoard() {
		AscendLeardningAboutUs.verifyLeaderPods("Greg Sebasky", "Larry Gold", "Marty Manning", "Ash Siebecker", "Mandeep Johar", "Jeff Jones",
				"Brian Kelly", "Laurie McCartney", "Ed Moura", "Kim Brophy");
	}
	
	@Test (priority=4, testName="Verify footer links")
	public void verifyFooterLinks() {
		AscendLeardningAboutUs.verifyFooterPrivacy();
		AscendLeardningAboutUs.verifyFooterTerms();
		AscendLeardningAboutUs.verifyFooterLinkedIn();
	}
	
}
