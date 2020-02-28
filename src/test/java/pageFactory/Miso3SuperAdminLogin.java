package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class Miso3SuperAdminLogin extends Base {

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailBox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordBox;

	@FindBy(xpath = "//button[text()=' Sign In ']")
	WebElement signInButton;

	@FindBy(xpath = "//div[@class='button-container']/a")
	WebElement forgotLink;

	@FindBy(xpath = "//div[@class='create-account']/a")
	WebElement createAccountLink;

	@FindBy(xpath = "//div[@class='support-links']/p/a")
	WebElement misoSupportLink;

	@FindBy(xpath="//div[text()=' Please enter a valid email ']")
	WebElement emailError;
	
	@FindBy(xpath="//div[text()=' Please enter your password ']")
	WebElement passwordError;
	
	
	public Miso3SuperAdminLogin() {
		PageFactory.initElements(driver, this);
	}

	public void emailBox(String email) {
		emailBox.sendKeys(email);
	}

	public void passwordBox(String password) {
		passwordBox.sendKeys(password);
	}

	public void signInButton() {
		signInButton.click();
	}

	public void forgotLink() {
		forgotLink.click();
	}

	public void createAccountLink() {
		createAccountLink.click();
	}

	public void misoSupportLink() {
		misoSupportLink.click();
	}

}
