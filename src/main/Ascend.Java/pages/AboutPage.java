package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AboutPage extends TestBase{
	
	//WebElement identifiers.
	@FindBy(xpath="//h1[@class='headline' and contains(text(),'Trust.')]")
	public WebElement headLine;
	@FindBy(xpath="//h4[@class='subhead' and contains(text(),'We')]")
	public WebElement subHead;
	
	@FindBy(xpath="//div[@class='block-grid-list']//li")
	public List<WebElement> blockGridList;
	
	@FindBy(xpath="//div[@class='value-pods']//div")
	public List<WebElement> valuePods;
	
	@FindBy(xpath="//div[@class='content-container']//div[@class='pod-label']//h4")
	public List<WebElement> leaderPods;
	
	@FindBy(id="menu-item-35")
	public WebElement footerPrivacy;
	@FindBy(id="menu-item-34")
	public WebElement footerTerms;
	@FindBy(id="menu-item-36")
	public WebElement footerLinkedIN;
	
	
	//Constructor
	public AboutPage(WebDriver driver) {
		this.Browser=driver;
		PageFactory.initElements(Browser, this);
	}
	
	//Page actions
	public boolean verifyPageHeader() {
		if (headLine.isDisplayed())
			ExtentTester.pass("Header for about page is available on about page");
		else 
			ExtentTester.fail("Header for about page is unavailable on about page");
		return headLine.isDisplayed();
	}
	public boolean verifyPageSubHeader() {
		if (subHead.isDisplayed())
			ExtentTester.pass("Sub heading for about page is available on about page");
		else 
			ExtentTester.fail("sub heading for about page is unavailable on about page");
		return subHead.isDisplayed();
	}
	
	public boolean verifyBlockGridList(String g1, String g2, String g3, String g4, String g5, String g6, String g7, String g8) {
		boolean flag =true;
		int counter=0;
		List<String> gridList = new ArrayList<String>();
		gridList.add(g1);
		gridList.add(g2);
		gridList.add(g3);
		gridList.add(g4);
		gridList.add(g5);
		gridList.add(g6);
		gridList.add(g7);
		gridList.add(g8);
		for (WebElement element: blockGridList) {
			if (gridList.contains(element.getText())) {
				flag=false;
				ExtentTester.fail("Value pod "+gridList.get(counter)+" doesn't exist on the page");
			}
			else {
				ExtentTester.pass("Value pod "+element.getText()+" exist on the page");
			}
			counter++;
		}
		return flag;
	}
	
	public boolean verifyValuePods(String g1, String g2, String g3, String g4, String g5, String g6) {
		boolean flag =true;
		int counter=0;
		List<String> gridList = new ArrayList<String>();
		gridList.add(g1);
		gridList.add(g2);
		gridList.add(g3);
		gridList.add(g4);
		gridList.add(g5);
		gridList.add(g6);
		for (WebElement element: valuePods) {
			if (gridList.contains(element.getText())) {
				flag=false;
				ExtentTester.fail("Value pod "+gridList.get(counter)+" doesn't exist on the page");
			}
			else {
				ExtentTester.pass("Value pod "+element.getText()+" exist on the page");
			}
			counter++;
		}
		return flag;
	}

	public boolean verifyLeaderPods(String g1, String g2, String g3, String g4, String g5, String g6, String g7, String g8, String g9, String g10) {
		boolean flag =true;
		int counter=0;
		List<String> gridList = new ArrayList<String>();
		gridList.add(g1);
		gridList.add(g2);
		gridList.add(g3);
		gridList.add(g4);
		gridList.add(g5);
		gridList.add(g6);
		gridList.add(g7);
		gridList.add(g8);
		gridList.add(g9);
		gridList.add(g10);
		for (WebElement element: leaderPods) {
			if (!gridList.contains(element.getAttribute("innerHTML"))) {
				flag=false;
				ExtentTester.fail("Leader "+gridList.get(counter)+" doesn't exist on the page");
			}
			else {
				ExtentTester.pass("Leader "+element.getText()+" exist on the page");
			}
			counter++;
		}
		return flag;
	}
	
	public boolean verifyFooterPrivacy() {
		if (footerPrivacy.isDisplayed())
			ExtentTester.pass("Footer link privacy is available on about page");
		else 
			ExtentTester.fail("Footer link privacy is unavailable on about page");
		return footerPrivacy.isDisplayed();
	}
	
	public boolean verifyFooterTerms() {
		if (footerTerms.isDisplayed())
			ExtentTester.pass("Footer link terms is available on about page");
		else 
			ExtentTester.fail("Footer link terms is unavailable on about page");
		return footerTerms.isDisplayed();
	}
	
	public boolean verifyFooterLinkedIn() {
		if (footerLinkedIN.isDisplayed())
			ExtentTester.pass("LinkedIn footer is available on about page");
		else 
			ExtentTester.fail("LinkedIn footer is unavailable on about page");
		return footerLinkedIN.isDisplayed();
	}
}
