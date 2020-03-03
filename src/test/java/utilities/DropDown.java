package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Base;

public class DropDown extends Base {
	
	public void conferenceTypeSelect(WebElement drop)
	{
		Select select = new Select(drop);
		select.selectByVisibleText("Web Only");
		select.selectByVisibleText("Audio Only");
	}
	

}
