package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void verify_Account_Registration() {
		HomePage HP = new HomePage(driver);
		HP.clickMyAccount();
		HP.clickRegister();

		AccountRegistrationPage AP = new AccountRegistrationPage(driver);
		AP.setFirstName(RandomString().toUpperCase());
		AP.setLastName(RandomString().toUpperCase());
		AP.setEmail(RandomString() + "@" + "gmail.com");
		AP.setTelephone(RandomNumber());
		String pwd = RandomAlphanumeric();
		AP.setPassword(pwd);
		AP.setConfirmPassword(pwd);
		AP.setPrivacyPolicy();
		AP.clickContinue();

		String ExpectedMessage = AP.getConfirmationMsg();
		AssertJUnit.assertEquals(ExpectedMessage, "Your Account Has Been Created!");

	}

}
