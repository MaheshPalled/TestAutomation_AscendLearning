package testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import testBase.TestBase;

public class HomePageTestCases extends TestBase{
	public  HomePage AscendLearningHomePage;
	public HomePageTestCases() throws Exception {
		
	}
	
	@Parameters("driver")
	@BeforeMethod
	public void setUp(Method method, String driver) throws IOException {
		super.setUpBrowser(driver);
		AscendLearningHomePage = new HomePage(Browser);
		ExtentTester = Reporter.createTest(method.getAnnotation(Test.class).testName());
	}
	
	@AfterMethod
	public void tearDown() {
		Browser.quit();
	}
	
	@Test (priority=1, testName ="Verify the browser tittle", suiteName="Regression")
	public void verifyTheBrowserTitle() {
		AscendLearningHomePage.verifyPageTittle("Ascend Learning");
	}
	
	@Test (priority=2, testName="Verify header links", suiteName="Regression")
	public void verifyHeaderLinks() {
		AscendLearningHomePage.verifyHeader_about();
		AscendLearningHomePage.verifyHeader_careers();
		AscendLearningHomePage.verifyHeader_contactUs();
		AscendLearningHomePage.verifyHeader_culture();
		AscendLearningHomePage.verifyHeader_investors();
		AscendLearningHomePage.verifyHeader_news();
		AscendLearningHomePage.verifyHeader_ourBusiness();
		AscendLearningHomePage.verifyHeader_search();
	}
	
	@Test (priority=3, testName="Verify the main heading and buttons available with it", suiteName="Regression")
	public void verifyTheHeading_AvailableButtonsAlong() {
		AscendLearningHomePage.verifyHomePage_Header();
		AscendLearningHomePage.verifyPresenseOf_LearnMoreButton();
		AscendLearningHomePage.verifyPresenseOf_JoinOurTeam();
	}
	
	@Test (priority=4, testName="Verify that there are 4 teaser points available", suiteName="Regression")
	public void verifyTheTeaserPodsAndContents() {
		AscendLearningHomePage.verifyTheContentOf_TeaserHeadPods("Clinicl Healthcare","Global Fitness & Wellness","Professional Certification & Licensure","Content Solutions");
		Browser.close();
	}
	
}
