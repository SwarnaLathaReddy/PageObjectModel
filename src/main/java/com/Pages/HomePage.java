package com.Pages;

import org.openqa.selenium.By;

import com.utilities.BaseClass;

public class HomePage extends BaseClass {
	
	
	public By HomePage_DealsGo_Button=By.xpath("(//a[contains(@onclick,'Deal Registration SFDC')])[2]");
	public By searchIframe=By.xpath("//iframe[@title='PCLM_PortalSideBarSearchPage']");
	public By searchBox=By.xpath("//input[@id='userInputValue']");

	public By searchGoButton=By.xpath("//input[@id='searchButton']");
	public By oppurtunity1NameLink=By.xpath("//a[text()='Test for US13451']");
	public By oppurtunityNametitle=By.xpath("//span[@class='pageTitleFont']");
	
	
	public void searchOptyID(String id) {
		String parent=driver.getWindowHandle();
		click(HomePage_DealsGo_Button);
		switchToNewTab(parent);
		switchToFrame(searchIframe);
		sendKeys(searchBox, id);
		click(searchGoButton);
		driver.switchTo().defaultContent();
		click(oppurtunity1NameLink);
		
	}
	
	public boolean verifyOptyID(String id) {
		return getText(oppurtunityNametitle).contains(id);
		
		
	}
	
	
	
	
	

}
