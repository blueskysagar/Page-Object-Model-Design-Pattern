package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
LoginPage loginpage;
HomePage homepage;
	
	
	public LoginPageTest() throws IOException {
		super();
		
	} 	
		
	@BeforeMethod

	public void SetUp() throws IOException {
		initialization();
	 loginpage = new LoginPage();
	}
	
	@Test(priority =1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void loginTest() throws IOException, InterruptedException {
	homepage   =  loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
		
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	

	
	
}
