package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import testBase.TestBase;

public class Utility extends TestBase {
	public static Properties prop;
	public static String getMyValue(String key) throws IOException {
		prop = new Properties();
		InputStream FIS = new FileInputStream("../AscendLearing/src/main/Ascend.Java/configuration/config.properties");
		prop.load(FIS);
		return prop.getProperty(key);
	}
	
	public static String takeScreenShot(ITestResult result) throws Exception {
		File SrcFile=((TakesScreenshot)Browser).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFile, new File("/Users/arunaarali/eclipse-workspace/AscendLearning"+result.getName()+".jpg"));
		return "/Users/arunaarali/eclipse-workspace/AscendLearning"+result.getName()+".jpg";
	}
}
