package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	//TestUtil testutil = new TestUtil();

	@FindBy(xpath = "//span[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newContactsLink;
	
	
	@FindBy(xpath = "//span[normalize-space()='Deals']")
	WebElement dealsLink;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException, InterruptedException {
		contactsLink.click();
		//testutil.moveMouseFor("//*[@id=\"top-header-menu\"]/div[2]/span[1]");
		return new ContactsPage();
	}
	public ContactsPage clickOnNewContactsLink() throws IOException {
		//Actions action = new Actions(driver);
		//action.moveToElement(contactsLink);
		newContactsLink.click();
		System.out.println("clicked new contact link");
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	

}
