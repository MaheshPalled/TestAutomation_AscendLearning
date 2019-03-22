package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class HomePage extends TestBase {
	//WebElement identifiers for the home page
	@FindBy(className="logo1")
	public WebElement ascendLearningLogo;
	@FindBy(id="menu-item-22")
	public WebElement about;
	@FindBy(id="menu-item-21")
	public WebElement ourBusiness;
	@FindBy(id="menu-item-522")
	public WebElement culture;
	@FindBy(id="menu-item-20")
	public WebElement careers;
	@FindBy(id="menu-item-921")
	public WebElement investors;
	@FindBy(id="menu-item-19")
	public WebElement contactUs;
	@FindBy(id="menu-item-1010")
	public WebElement news;
	@FindBy(id="menu-item-37")
	public WebElement search;
	//Header and the related buttons.
	@FindBy(xpath="//h1[@class='headline' and contains(text(),'We don')]")
	public WebElement mainHeader;
	@FindBy(xpath="//a [@title='Learn More']")
	public WebElement learnMoreButton;
	@FindBy(xpath="//div[@class='cta-buttons']//a [@href='https://www.ascendlearning.com/careers/' and @class='bordered-button']")
	public WebElement joinOurTeamButton;
	//Brand teaser pods
	@FindBy(xpath="//div[@class='brand-teaser-pods']//div[@class='pod-label']/h4")
	public List<WebElement> brandTeaserPods;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.Browser = driver;
		PageFactory.initElements(Browser, this);
	}
	
	
	//Actions
	
	public boolean verifyPageTittle(String title) {
		return Browser.getTitle().equals(title)?true:false;
	}
	
	public boolean verifyAscendLogo_inHomePage() {
		if (ascendLearningLogo.isDisplayed())
			ExtentTester.pass("Ascend Learning logo is available on home page");
		else 
			ExtentTester.fail("Ascend Learning logo is available on home page");
		return ascendLearningLogo.isDisplayed();
	}
	
	public boolean verifyHeader_about() {
		if (about.isDisplayed())
			ExtentTester.pass("About header is available on home page");
		else 
			ExtentTester.fail("About header is available on home page");
		return about.isDisplayed();
	}
	
	public boolean verifyHeader_ourBusiness() {
		if (ourBusiness.isDisplayed())
			ExtentTester.pass("Our business header is available on home page");
		else 
			ExtentTester.fail("Our business header is available on home page");
		return ourBusiness.isDisplayed();
	}
	
	public boolean verifyHeader_culture() {
		if (culture.isDisplayed())
			ExtentTester.pass("Culture header is available on home page");
		else 
			ExtentTester.fail("Culture header is unavailable on home page");
		return culture.isDisplayed();
	}
	
	public boolean verifyHeader_careers() {
		if (careers.isDisplayed())
			ExtentTester.pass("Careers header is available on home page");
		else 
			ExtentTester.fail("Careers header is unavailable on home page");
		return careers.isDisplayed();
	}
	
	public boolean verifyHeader_investors() {
		if(investors.isDisplayed())
			ExtentTester.pass("Investors header is available on home page");
		else 
			ExtentTester.pass("Investors header is unavailable on home page");
		return investors.isDisplayed();
	}
	
	public boolean verifyHeader_contactUs() {
		if (contactUs.isDisplayed())
			ExtentTester.pass("Contact us header is available on home page");
		else 
			ExtentTester.fail("Contact us header is unavailable on home page");
		return contactUs.isDisplayed();
	}
	
	public boolean verifyHeader_news() {
		if (news.isDisplayed())
			ExtentTester.pass("News header is available on home page");
		else 
			ExtentTester.fail("News header is unavailable on home page");
		return news.isDisplayed();
	}
	
	public boolean verifyHeader_search() {
		if (search.isDisplayed())
			ExtentTester.pass("Search is available on home page");
		else 
			ExtentTester.fail("search is unavailable on home page");
		return search.isDisplayed();
	}
	
	public boolean verifyHomePage_Header() {
		if (mainHeader.getAttribute("innerHTML")=="We don’t obsess over changing someone’s life.") return mainHeader.isDisplayed();
		return false;
	}
	
	public boolean verifyPresenseOf_LearnMoreButton() {
		if (learnMoreButton.isDisplayed())
			ExtentTester.pass("Learn more button is available on home page");
		else 
			ExtentTester.fail("Learn more button is unavailable on home page");
		return learnMoreButton.isDisplayed();
	}
	
	public boolean verifyPresenseOf_JoinOurTeam() {
		if (joinOurTeamButton.isDisplayed())
		ExtentTester.pass("Join our team button exist");
		else 
		ExtentTester.fail("Join our team button Doesn't exist");
		return joinOurTeamButton.isDisplayed(); 
	}
	
	//Sample Test case to display the content of teaser head pods
	public boolean verifyTheContentOf_TeaserHeadPods(String teaser1, String teaser2, String teaser3, String teaser4) {
		boolean flag=true;
		int counter=0;
		List<String> TeaserPods = new ArrayList<String>();
		TeaserPods.add(teaser1);
		TeaserPods.add(teaser2);
		TeaserPods.add(teaser3);
		TeaserPods.add(teaser4);
		for (WebElement element : brandTeaserPods) {
			if (!TeaserPods.contains(element.getText())) {
				flag=false;
				ExtentTester.fail(TeaserPods.get(counter)+" Teaser pod doesn't exist");
			}
			else {
				ExtentTester.pass(element.getText()+" Teaser pod exist");
			}
			counter++;
		}
		return flag;
	}
	
	public AboutPage clickAbout(WebDriver driver) {
		about.click();
		ExtentTester.pass("User Navigated to About page.");
		return new AboutPage(driver);
	}
	
	public ContactusPage clickContctUS() {
		contactUs.click();
		ExtentTester.pass("User Navigated to Contact us page.");
		return new ContactusPage(Browser);
	}
}
