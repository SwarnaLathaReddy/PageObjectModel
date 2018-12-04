package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public void openBrowser(String browser) 
	{
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	public String readConfig(String key) throws Throwable 
	{
			
		FileInputStream fi=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\PageObjectModel\\Configuration\\Config.properties");
		Properties prop=new Properties();
		prop.load(fi);
		 return prop.getProperty(key);
	}
	
	public void openApplication(String url) 
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void sendKeys(By by, String text) 
	{
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}
	
	public void click(By by) 
	{
		driver.findElement(by).click();
	}
	
	public String getTitle() 
	{
		return driver.getTitle().trim();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void switchToNewTab(String parent) {
		
		 Set<String>handles=driver.getWindowHandles();
		for(String child:handles) {
			if(!child.contains(parent)) {
				driver.switchTo().window(child);
				break;
			}
		}
		
	}
	public void switchToParent(String parent) {
		driver.switchTo().window(parent);
			
	}
	
	public void switchToFrame(By by) {
		driver.switchTo().frame(driver.findElement(by));
	}
	
	public String getText(By by) {
		return driver.findElement(by).getText().trim();
	}
	
	
}
