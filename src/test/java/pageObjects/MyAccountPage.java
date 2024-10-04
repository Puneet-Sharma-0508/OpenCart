package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement Logout;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement MyAccountText;

	public void clickLogout() {
		Logout.click();
	}

	public boolean pageexists() {
		try {
			return (MyAccountText.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

}
