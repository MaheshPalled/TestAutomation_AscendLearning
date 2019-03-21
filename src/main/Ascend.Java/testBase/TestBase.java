package testBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Utility;

public class TestBase {
	public static WebDriver Browser;
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
	
	
}
