package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class Miso3SuperAdminLogin extends Base {
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordBox;
	
	@FindBy(xpath="//button[text()=' Sign In ']")
	WebElement signInButton;
	
	@FindBy(xpath="//div[@class='button-container']/a")
	WebElement forgotLink;
	
	@FindBy(xpath="//div[@class='create-account']/a")
	WebElement createLink;
	
	@FindBy(xpath="//div[@class='support-links']/p/a")
	WebElement misoSupportLink;
	
	public Miso3SuperAdminLogin()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String emailBox(String email)
	{
		emailBox.sendKeys(email);
		return email;
	}
	
	
}
