package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import testBase.TestBase;

public class Utility extends TestBase {
	public static Properties prop;
	public static String getMyValue(String key) throws IOException {
		prop = new Properties();
		InputStream FIS = new FileInputStream("../AscendLearing/src/main/Ascend.Java/configuration/config.properties");
		prop.load(FIS);
		return prop.getProperty(key);
	}
	
	public static void takeScreenShot(String name) {
		
	}
}
