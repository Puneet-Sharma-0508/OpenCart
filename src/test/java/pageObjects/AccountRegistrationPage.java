package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement Telephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement PrivacyPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Continue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement MsgConfirmation;

	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setTelephone(String tel) {
		Telephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		ConfirmPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		PrivacyPolicy.click();
	}

	public void clickContinue() {
		try {
			Continue.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Continue);
		}
	}

	public String getConfirmationMsg() {
		return (MsgConfirmation.getText());
	}

}
