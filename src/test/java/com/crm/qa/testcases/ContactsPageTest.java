package com.crm.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	TestUtil testutil;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName = "contacts";

	
	public ContactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod

	public void SetUp() throws IOException, InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();
		 
	}
	@Test(priority = 1)
	public void verifyContactsLabelPage() {
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing");
		System.out.println("Test1 passed");
	}
	@Test(priority = 2)
	public void selectContactsTest() {
		testutil.moveMouseFor("//*[@id=\"top-header-menu\"]/div[2]/span[1]");
		contactspage.selectContactsByName("sagar Shrestha");
		System.out.println("Test2 passed");
	}
	@Test(priority = 3)
	
	public void selectMultipleContactsTest() {
		testutil.moveMouseFor("//*[@id=\"top-header-menu\"]/div[2]/span[1]");
		contactspage.selectContactsByName("karki sachit");
		contactspage.selectContactsByName("Pradhan Sagar");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContactsLink(String FirstName, String LastName, String Category) throws IOException {
		homepage.clickOnNewContactsLink();
		contactspage.createNewContact(FirstName, LastName, Category);
		//contactspage.createNewContacts( "Lead", "Shrestha", "Sagar" );
	}
	
	//@AfterMethod
	//public void TearDown() {
	//	driver.quit();
	//}
	
	
	
		
	}

