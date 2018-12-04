package com.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.utilities.BaseClass;

public class TC_01 extends BaseClass {
	
	@BeforeMethod
	public void beforeMethod() throws Throwable 
	{
		openBrowser(readConfig("browser"));
		openApplication(readConfig("url"));
		
	}

	
  @Test
  public void test() 
  {
	  try {
	  LoginPage login=new LoginPage();
		login.getLogin(readConfig("username"), readConfig("password"));
		assertEquals(getTitle(),readConfig("homePageTitle"));
		HomePage home=new HomePage();
		home.searchOptyID(readConfig("oppurtunityId"));
		assertTrue(home.verifyOptyID(readConfig("oppurtunityId")));
	} catch (Throwable e) {
		e.printStackTrace();
	}
	  
  }
  
  
  @AfterMethod
  public void afterMethod() 
  {
  quit();
  }
  
}
