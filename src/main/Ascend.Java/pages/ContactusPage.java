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
		return contactUsHeader.isDisplayed();
	}
	
	public boolean verifyLocationMap() {
		return locationMap.isDisplayed();
	}
	
	public void displayTheAvailableLocation() {
		for (WebElement element:availableLocations) {
			System.out.println(element.getText());
		}
	}
}
