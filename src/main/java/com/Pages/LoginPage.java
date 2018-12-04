package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utilities.BaseClass;

public class LoginPage extends BaseClass {
	
	
	public By login_UserName=By.xpath("//input[@id='USER']");
	
	public By login_Password=By.xpath("//input[@id='PASSWORD']");
	
	public By login_Button=By.xpath("//input[@value='Sign In']");
	
	//public By title=By.xpath("//div[@id='divLogo']/img");
	

	/*another method of finding elements by using findby
			@FindBy(how=How.XPATH,using="//input[@id='USER']")
			WebElement username1;
			//or
			@FindBy(xpath="//input[@id='USER']")
			WebElement user;
	*/
	

	public void getLogin(String username,String password) {
		
		sendKeys(login_UserName,username);
		sendKeys(login_Password,password);
		click(login_Button);
		
	
	}
	
	
}
