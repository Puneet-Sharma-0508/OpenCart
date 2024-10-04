package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement Login;

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickLogin() {
		Login.click();
	}

}
