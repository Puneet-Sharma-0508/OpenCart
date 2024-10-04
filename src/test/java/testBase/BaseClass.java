package testBase;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Properties p;

	@BeforeClass(groups= {"Sanity","Master","Regression"})
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {
		
		FileInputStream FS = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		p = new Properties();
		p.load(FS);

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser");
			return;

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {

		driver.quit();

	}

	public String RandomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String RandomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String RandomAlphanumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(10);

		String generatedAlphanumeric = generatedString + generatedNumber;
		return generatedAlphanumeric;

	}

}
