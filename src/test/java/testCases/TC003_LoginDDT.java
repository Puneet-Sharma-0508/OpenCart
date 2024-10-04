package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException {

		HomePage HP = new HomePage(driver);
		HP.clickMyAccount();
		HP.clickLogin();

		LoginPage LP = new LoginPage(driver);
		LP.setEmail(email);
		LP.setPassword(password);
		LP.clickLogin();

		MyAccountPage MAP = new MyAccountPage(driver);
		boolean targetPage = MAP.pageexists();

		if (exp.equalsIgnoreCase("valid")) {

			if (targetPage == true) {
				MAP.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("invalid")) {

			if (targetPage == true) {

				MAP.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
			
		}

	}

}
