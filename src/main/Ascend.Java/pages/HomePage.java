package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase {
	//WebElement identifiers for the home page
	@FindBy(className="logo")
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
		return ascendLearningLogo.isDisplayed();
	}
	
	public boolean verifyHeader_about() {
		return about.isDisplayed();
	}
	
	public boolean verifyHeader_ourBusiness() {
		return ourBusiness.isDisplayed();
	}
	
	public boolean verifyHeader_culture() {
		return culture.isDisplayed();
	}
	
	public boolean verifyHeader_careers() {
		return careers.isDisplayed();
	}
	
	public boolean verifyHeader_investors() {
		return investors.isDisplayed();
	}
	
	public boolean verifyHeader_contactUs() {
		return contactUs.isDisplayed();
	}
	
	public boolean verifyHeader_news() {
		return news.isDisplayed();
	}
	
	public boolean verifyHeader_search() {
		return search.isDisplayed();
	}
	
	public boolean verifyHomePage_Header() {
		if (mainHeader.getAttribute("innerHTML")=="We don’t obsess over changing someone’s life.") return mainHeader.isDisplayed();
		return false;
	}
	
	public boolean verifyPresenseOf_LearnMoreButton() {
		return learnMoreButton.isDisplayed();
	}
	
	public boolean verifyPresenseOf_JoinOurTeam() {
		return joinOurTeamButton.isDisplayed(); 
	}
	
	//Sample Test case to display the content of teaser head pods
	public boolean verifyTheContentOf_TeaserHeadPods(String teaser1, String teaser2, String teaser3, String teaser4) {
		boolean flag=true;
		List<String> TeaserPods = new ArrayList<String>();
		TeaserPods.add(teaser1);
		TeaserPods.add(teaser2);
		TeaserPods.add(teaser3);
		TeaserPods.add(teaser4);
		for (WebElement element : brandTeaserPods) {
			if (!TeaserPods.contains(element.getText())) {
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public AboutPage clickAbout(WebDriver driver) {
		about.click();
		return new AboutPage(driver);
	}
	
	public ContactusPage clickContctUS() {
		contactUs.click();
		return new ContactusPage(Browser);
	}
}
