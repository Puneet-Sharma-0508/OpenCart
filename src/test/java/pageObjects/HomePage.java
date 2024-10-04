package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='caret']")
	WebElement MyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a")
	WebElement Register;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
	WebElement Login;

	public void clickMyAccount() {
		MyAccount.click();

	}

	public void clickRegister() {
		Register.click();
	}
	
	public void clickLogin() {
		Login.click();
	}

}
