package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class ContactusPage extends TestBase{
	@FindBy(className="text-block")
	public WebElement contactUsHeader;
	@FindBy(className="location-map")
	public WebElement locationMap;
	@FindBy(xpath="//div[@class='location-pod']//h4")
	public List<WebElement> availableLocations;
	
	//Constructor
	public ContactusPage(WebDriver Driver) {
		this.Browser=Driver;
		PageFactory.initElements(Browser, this);
	}
	
	//Page actions
	public boolean verifyContactUsHeader() {
		if (contactUsHeader.isDisplayed())
			ExtentTester.pass("Contact us header is available on home page");
		else 
			ExtentTester.fail("Contact us header is unavailable on home page");
		return contactUsHeader.isDisplayed();
	}
	
	public boolean verifyLocationMap() {
		if (locationMap.isDisplayed())
			ExtentTester.pass("Location map is available on home page");
		else 
			ExtentTester.fail("Location map is unavailable on home page");
		return locationMap.isDisplayed();
	}
	
	public void displayTheAvailableLocation() {
		for (WebElement element:availableLocations) {
			ExtentTester.pass("Location map is available on home page"+element.getText());
		}
	}
}
