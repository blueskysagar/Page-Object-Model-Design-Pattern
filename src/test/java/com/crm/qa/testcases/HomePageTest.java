package com.crm.qa.testcases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactspage;

	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod

	public void SetUp() throws IOException, InterruptedException {
		initialization();
	 loginPage = new LoginPage();
	homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	 
	}
	
	@Test(priority =1)
	public void verifyUserTest() {
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority = 2)
	public void verifyContactsLinkTest() throws IOException, InterruptedException {
		contactspage =homepage.clickOnContactsLink();
	}
	
	
		
		
	
	
	@AfterMethod
	public void TearDown() {
               // sagar
		driver.quit();
	}


}
