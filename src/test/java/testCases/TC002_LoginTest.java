package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void verifiy_Login() {
		
		HomePage HP = new HomePage(driver);
		HP.clickMyAccount();
		HP.clickLogin();

		LoginPage LP = new LoginPage(driver);
		LP.setEmail(p.getProperty("email"));
		LP.setPassword(p.getProperty("password"));
		LP.clickLogin();
		
		MyAccountPage MAP = new MyAccountPage(driver);
		boolean targetPage=MAP.pageexists();
		
		Assert.assertTrue(targetPage);
	}

}
